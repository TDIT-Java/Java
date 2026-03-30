package com.reportsservice.jasper;

import com.reportsservice.dto.response.PastBillRow;
import com.reportsservice.dto.response.PendingBillRow;
import com.reportsservice.exceptions.ReportGenerationException;
import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.*;

import net.glxn.qrgen.javase.QRCode;

import java.io.ByteArrayInputStream;

@Component
public class JasperReportHelper {

    private static final String REPORT_PATH = "reports/ElectricityBill.jrxml";

    public byte[] generateBillPdf(
            Map<String, Object> fields,
            List<PendingBillRow> pendingBills,
            List<PastBillRow> paidBills) {

        try {
            ClassPathResource resource = new ClassPathResource(REPORT_PATH);
            if (!resource.exists()) {
                throw new ReportGenerationException(
                        "JRXML file not found at: " + REPORT_PATH
                                + " — place ElectricityBill.jrxml in src/main/resources/reports/",
                        new RuntimeException("File not found"));
            }

            InputStream reportStream = resource.getInputStream();
            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            // CONVERT LIST → ARRAYS (IMPORTANT)
            List<String> pendingMonths = new ArrayList<>();
            List<Integer> pendingUnits = new ArrayList<>();
            List<Double> pendingAmounts = new ArrayList<>();

            for (PendingBillRow row : pendingBills) {
                pendingMonths.add(row.getMonth());
                pendingUnits.add(row.getUnits());
                pendingAmounts.add(row.getAmount());
            }

            List<String> paidMonths = new ArrayList<>();
            List<Integer> paidUnits = new ArrayList<>();
            List<Double> paidAmounts = new ArrayList<>();
            List<LocalDateTime> billPaidDateTimes = new ArrayList<>();

            for (PastBillRow row : paidBills) {
                paidMonths.add(row.getMonth());
                paidUnits.add(row.getUnits());
                paidAmounts.add(row.getBillPaid());
                billPaidDateTimes.add(row.getPaidDateTime());
            }

            // Generate QR image
            // QR SAFE
            String qrText = (String) fields.get("qrData");

            InputStream qrImage = null;
            if (qrText != null && !qrText.isBlank()) {
                ByteArrayOutputStream qrOutputStream = QRCode
                        .from(qrText)
                        .withSize(120, 120)
                        .stream();

                qrImage = new ByteArrayInputStream(qrOutputStream.toByteArray());
            }

            fields.put("qrImage", qrImage);

            // PARAMETERS MAP
            Map<String, Object> parameters = new HashMap<>(fields);

            parameters.put("pendingMonths", pendingMonths);
            parameters.put("pendingUnits", pendingUnits);
            parameters.put("pendingAmounts", pendingAmounts);

            parameters.put("pastMonths", paidMonths);
            parameters.put("pastUnits", paidUnits);
            parameters.put("pastAmounts", paidAmounts);
            parameters.put("billPaidDateTime", billPaidDateTimes);

            // FILL REPORT
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    parameters,
                    new JREmptyDataSource(1));

            String outputPath = "output/" + fields.get("customerId") + ".pdf";

            java.io.File outputDir = new java.io.File("output");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // Create output directory
            File outputFile = new File(outputPath);
            File parentDir = outputFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            JasperExportManager.exportReportToPdfFile(jasperPrint, String.valueOf(outputFile));

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (ReportGenerationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ReportGenerationException(
                    "Failed to generate bill PDF: " + ex.getMessage(), ex);
        }
    }
}
