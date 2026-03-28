package com.reportsservice.jasper;

import com.reportsservice.dto.response.PastBillRow;
import com.reportsservice.dto.response.PendingBillRow;
import com.reportsservice.exceptions.ReportGenerationException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.glxn.qrgen.javase.QRCode;

import java.io.ByteArrayInputStream;

@Component
public class JasperReportHelper {

    private static final String REPORT_PATH = "reports/ElectricityBill.jrxml";

    public byte[] generateBillPdf(
            Map<String, Object> fields,
            List<PendingBillRow> pendingBills,
            List<PastBillRow> pastBills) {

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
            List<String> pendingMonths = new java.util.ArrayList<>();
            List<Integer> pendingUnits = new java.util.ArrayList<>();
            List<Double> pendingAmounts = new java.util.ArrayList<>();

            for (PendingBillRow row : pendingBills) {
                pendingMonths.add(row.getMonth());
                pendingUnits.add(row.getUnits());
                pendingAmounts.add(row.getAmount());
            }

            List<String> pastMonths = new java.util.ArrayList<>();
            List<Integer> pastUnits = new java.util.ArrayList<>();
            List<Double> pastAmounts = new java.util.ArrayList<>();

            for (PastBillRow row : pastBills) {
                pastMonths.add(row.getMonth());
                pastUnits.add(row.getUnits());
                pastAmounts.add(row.getBillPaid());
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

            // LIMIT LIST SIZE
            int limit = Math.min(pendingBills.size(), 5);
            for (int i = 0; i < limit; i++) {
                PendingBillRow row = pendingBills.get(i);
                pendingMonths.add(row.getMonth());
                pendingUnits.add(row.getUnits());
                pendingAmounts.add(row.getAmount());
            }

            // PARAMETERS MAP
            Map<String, Object> parameters = new HashMap<>(fields);

            parameters.put("pendingMonths", pendingMonths);
            parameters.put("pendingUnits", pendingUnits);
            parameters.put("pendingAmounts", pendingAmounts);

            parameters.put("pastMonths", pastMonths);
            parameters.put("pastUnits", pastUnits);
            parameters.put("pastAmounts", pastAmounts);

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
