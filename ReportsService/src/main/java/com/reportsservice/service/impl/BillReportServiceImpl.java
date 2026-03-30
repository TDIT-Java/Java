package com.reportsservice.service.impl;

import com.reportsservice.dto.request.BillReportRequest;
import com.reportsservice.dto.response.*;
import com.reportsservice.entity.*;
import com.reportsservice.enums.BillMonth;
import com.reportsservice.enums.PaymentStatus;
import com.reportsservice.exceptions.*;
import com.reportsservice.jasper.JasperReportHelper;
import com.reportsservice.repository.*;
import com.reportsservice.service.BillReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillReportServiceImpl implements BillReportService {

    private final ConsumerRepository consumerRepository;
    private final BillRepository billRepository;
    private final MeterReadingRepository meterReadingRepository;
    private final JasperReportHelper jasperReportHelper;

    @Override
    @Transactional(readOnly = true)
    public BillReportResponse generateBillReport(BillReportRequest request) {

        log.info("Generating bill report → ConsumerID: {}, Month: {}, Year: {}",
                request.getId(), request.getMonth(), request.getYear());

        // Convert String month to BillMonth enum
        BillMonth billMonth = BillMonth.valueOf(request.getMonth().toUpperCase());

        // 1. Fetch Consumer
        Consumer consumer = consumerRepository
                .findActiveConsumerById(request.getId())
                .orElseThrow(() -> new ConsumerNotFoundException(request.getId()));

        // 2. Fetch Current Bill
        Bill currentBill = billRepository
                .findBill(consumer.getId(), billMonth, request.getYear())
                .orElseThrow(() -> new BillNotFoundException(
                        consumer.getId(), request.getMonth(), request.getYear()));

        // 3. Ensure MeterReading is loaded
        MeterReading reading = currentBill.getMeterReading();
        if (reading == null) {
            // Fallback: Try to find reading directly if link was broken
            reading = meterReadingRepository
                    .findByConsumerIdAndBillingMonth(consumer.getId(), billMonth, request.getYear())
                    .orElse(null);
        }

        // 4. Fetch Pending Bills
        List<Bill> pendingBills = billRepository.findPendingBills(
                consumer.getId(),
                List.of(PaymentStatus.PENDING, PaymentStatus.PARTIALLY_PAID, PaymentStatus.OVERDUE));

        // 5. Fetch Past Paid Bills
        List<Bill> paidBills = billRepository.findPastPaidBills(
                consumer.getId(),
                PaymentStatus.PAID
        );

        // 6. Build Jasper Fields
        Map<String, Object> fields = buildFieldsMap(consumer, currentBill, reading);

        // 7. Build Table Rows
        List<PendingBillRow> pendingRows = buildPendingRows(pendingBills);
        List<PastBillRow> paidRows = buildPastRows(paidBills);

        // 8. Generate PDF
        byte[] pdfBytes = jasperReportHelper.generateBillPdf(fields, pendingRows, paidRows);

        String fileName = "BILL_" + consumer.getConsumerNo() + "_"
                + billMonth.name() + "_" + request.getYear() + ".pdf";

        log.info("Bill report generated → {}", fileName);

        return BillReportResponse.builder()
                .success(true)
                .message("Bill report generated successfully")
                .fileName(fileName)
                .pdfData(pdfBytes)
                .build();
    }

    // PRIVATE HELPERS

    private Map<String, Object> buildFieldsMap(Consumer consumer, Bill bill, MeterReading reading) {

        Address address = consumer.getAddress();
        City city = address.getCity();

        // Calculate Units Consumed dynamically from Reading if available
        // Otherwise fallback to Bill snapshot
        int unitsConsumedVal = 0;
        if (reading != null && reading.getCurrentReading() != null && reading.getPreviousReading() != null) {
            unitsConsumedVal = reading.getCurrentReading()
                    .subtract(reading.getPreviousReading())
                    .intValue();
        } else if (bill.getUnitsConsumed() != null) {
            unitsConsumedVal = bill.getUnitsConsumed();
        }

        // Rate per unit
        double ratePerUnit = 0.0;
        if (unitsConsumedVal > 0 && bill.getEnergyCharges() != null) {
            ratePerUnit = bill.getEnergyCharges()
                    .divide(BigDecimal.valueOf(unitsConsumedVal), 4, RoundingMode.HALF_UP)
                    .doubleValue();
        }

        // After due amount
        BigDecimal surcharge = bill.getLatePaymentSurcharge() != null
                ? bill.getLatePaymentSurcharge() : BigDecimal.ZERO;
        double afterDueAmount = bill.getNetAmount().add(surcharge).doubleValue();

        Map<String, Object> fields = new HashMap<>();

        fields.put("customerName", buildFullName(consumer));
        fields.put("customerId", consumer.getConsumerNo());
        fields.put("billingAddress", buildFullAddress(address, city));
        fields.put("emailId", consumer.getEmail().getEmail());
        fields.put("phoneNumber", consumer.getPhoneNumber().getPrimaryMobile());

        fields.put("billNumber", bill.getBillNumber());
        fields.put("billDate", bill.getBillDate().toString());
        fields.put("dueDate", bill.getDueDate().toString());

        // Use Reading Date if available
        String readingDateStr = "N/A";
        if (reading != null && reading.getReadingDate() != null) {
            readingDateStr = reading.getReadingDate().toString();
        } else if (bill.getMeterReading() != null && bill.getMeterReading().getReadingDate() != null) {
            readingDateStr = bill.getMeterReading().getReadingDate().toString();
        }
        fields.put("meterReadingDate", readingDateStr);

        fields.put("billGeneratedDate", bill.getCreatedAt() != null
                ? bill.getCreatedAt().toLocalDate().toString() : bill.getBillDate().toString());

        // Use calculated values
        int currRead = (reading != null && reading.getCurrentReading() != null)
                ? reading.getCurrentReading().intValue()
                : (bill.getCurrentReading() != null ? bill.getCurrentReading().intValue() : 0);

        int prevRead = (reading != null && reading.getPreviousReading() != null)
                ? reading.getPreviousReading().intValue()
                : (bill.getPreviousReading() != null ? bill.getPreviousReading().intValue() : 0);

        fields.put("currentReading", currRead);
        fields.put("previousReading", prevRead);
        fields.put("unitsConsumed", unitsConsumedVal);

        fields.put("ratePerUnit", ratePerUnit);
        fields.put("totalAmountPay", bill.getNetAmount().doubleValue());
        fields.put("afterDueAmount", afterDueAmount);
        fields.put("qrData", buildQrData(consumer, bill));

        return fields;
    }

    private List<PendingBillRow> buildPendingRows(List<Bill> bills) {
        List<PendingBillRow> rows = new ArrayList<>();
        for (Bill b : bills) {
            rows.add(PendingBillRow.builder()
                    .month(b.getBillingMonth().name() + "-" + b.getBillingYear())
                    .units(b.getUnitsConsumed() != null ? b.getUnitsConsumed() : 0)
                    .amount(b.getNetAmount().doubleValue())
                    .build());
        }
        return rows;
    }

    private List<PastBillRow> buildPastRows(List<Bill> bills) {
        List<PastBillRow> rows = new ArrayList<>();
        for (Bill b : bills) {
            rows.add(PastBillRow.builder()
                    .month(b.getBillingMonth().name() + "-" + b.getBillingYear())
                    .units(b.getUnitsConsumed() != null ? b.getUnitsConsumed() : 0)
                    .billPaid(b.getAmountPaid() != null ? b.getAmountPaid().doubleValue() : 0.0)
                    .paidDateTime(b.getBillPaidDateTime())
                    .build());
        }
        return rows;
    }

    private String buildFullName(Consumer consumer) {
        StringBuilder sb = new StringBuilder();
        sb.append(consumer.getFirstName()).append(" ");
        if (consumer.getMiddleName() != null && !consumer.getMiddleName().isBlank()) {
            sb.append(consumer.getMiddleName()).append(" ");
        }
        sb.append(consumer.getLastName());
        return sb.toString().trim();
    }

    private String buildFullAddress(Address address, City city) {
        StringBuilder sb = new StringBuilder();
        sb.append(address.getAddressLine1());
        if (address.getAddressLine2() != null && !address.getAddressLine2().isBlank()) {
            sb.append(", ").append(address.getAddressLine2());
        }
        if (address.getAddressLine3() != null && !address.getAddressLine3().isBlank()) {
            sb.append(", ").append(address.getAddressLine3());
        }
        if (address.getLandmark() != null && !address.getLandmark().isBlank()) {
            sb.append(", Near ").append(address.getLandmark());
        }
        sb.append(", ").append(city.getCityName());
        sb.append(", ").append(city.getDistrict().getDistrictName());
        sb.append(" - ").append(city.getPincode().getPincode());
        return sb.toString();
    }

    private String buildQrData(Consumer consumer, Bill bill) {
        return "ConsumerNo:" + consumer.getConsumerNo()
                + "|BillNo:" + bill.getBillNumber()
                + "|Month:" + bill.getBillingMonth().name()
                + "|Year:" + bill.getBillingYear()
                + "|Amount:" + bill.getNetAmount()
                + "|DueDate:" + bill.getDueDate();
    }
}
