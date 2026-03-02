package org.Java;

import org.Java.Service.ReportService;
import org.Java.util.DatabaseConnection;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting PDF Report Generation...");

        try {
            ReportService reportService = new ReportService();

            // Generate PDF report
            String outputPath = "output/person_report.pdf";

            // Create output directory if it doesn't exist
            java.io.File outputDir = new java.io.File("output");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // Generate the report
            reportService.generatePdfReport(outputPath);

            System.out.println("Report generation completed!");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
}