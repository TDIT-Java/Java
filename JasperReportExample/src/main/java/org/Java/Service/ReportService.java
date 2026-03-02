package org.Java.Service;

import org.Java.Dao.PersonDAO;
import org.Java.Model.Person;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    private PersonDAO personDAO;

    public ReportService() {
        this.personDAO = new PersonDAO();
    }

    public void generatePdfReport(String outputPath) {
        InputStream reportStream = null;

        try {
            // Try multiple ways to load the JRXML file

            // Method 1: From classpath with leading slash
            reportStream = getClass().getResourceAsStream("/reports/person_report.jrxml");
            System.out.println("Method 1 (getResourceAsStream with /): " + (reportStream != null ? "Found" : "Not Found"));

            // Method 2: From classpath without leading slash using ClassLoader
            if (reportStream == null) {
                reportStream = getClass().getClassLoader().getResourceAsStream("reports/person_report.jrxml");
                System.out.println("Method 2 (ClassLoader): " + (reportStream != null ? "Found" : "Not Found"));
            }

            // Method 3: From file system (project root)
            if (reportStream == null) {
                String filePath = "src/main/resources/reports/person_report.jrxml";
                File file = new File(filePath);
                System.out.println("Method 3 - Checking file: " + file.getAbsolutePath());
                System.out.println("File exists: " + file.exists());

                if (file.exists()) {
                    reportStream = new FileInputStream(file);
                    System.out.println("Method 3 (File System): Found");
                }
            }

            // Method 4: From file system (absolute path based on current directory)
            if (reportStream == null) {
                String currentDir = System.getProperty("user.dir");
                String filePath = currentDir + "/src/main/resources/reports/person_report.jrxml";
                File file = new File(filePath);
                System.out.println("Method 4 - Checking file: " + file.getAbsolutePath());

                if (file.exists()) {
                    reportStream = new FileInputStream(file);
                    System.out.println("Method 4 (Absolute Path): Found");
                }
            }

            // If still not found, show error
            if (reportStream == null) {
                System.err.println("\n========================================");
                System.err.println("ERROR: JRXML file not found!");
                System.err.println("========================================");
                System.err.println("Please create the file at:");
                System.err.println("  src/main/resources/reports/person_report.jrxml");
                System.err.println("\nCurrent working directory: " + System.getProperty("user.dir"));
                System.err.println("========================================\n");
                return;
            }

            System.out.println("\n✓ Report template loaded successfully!");

            // Compile the report
            System.out.println("Compiling report...");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
            System.out.println("✓ Report compiled successfully!");

            // Get data from database
            System.out.println("Fetching data from database...");
            List<Person> persons = personDAO.getAllPersons();
            System.out.println("✓ Found " + persons.size() + " records");

            // If no data, add sample data for testing
            if (persons.isEmpty()) {
                System.out.println("No data in database. Adding sample data for testing...");
                persons = getSampleData();
            }

            // Create data source
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(persons);

            // Parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("reportTitle", "Person Information Report");
            parameters.put("company", "My Company");

            // Fill the report
            System.out.println("Filling report with data...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            System.out.println("✓ Report filled successfully!");

            // Create output directory
            File outputFile = new File(outputPath);
            File parentDir = outputFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Export to PDF
            System.out.println("Exporting to PDF...");
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);

            System.out.println("\n========================================");
            System.out.println("✓ PDF Report generated successfully!");
            System.out.println("Location: " + new File(outputPath).getAbsolutePath());
            System.out.println("========================================\n");

        } catch (JRException e) {
            System.err.println("JasperReports Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (reportStream != null) {
                try {
                    reportStream.close();
                } catch (Exception e) {
                    // ignore
                }
            }
        }
    }

    // Sample data for testing
    private List<Person> getSampleData() {
        List<Person> persons = new java.util.ArrayList<>();
        persons.add(new Person(1, "John Doe", "1234567890", "john@email.com", "123 Main St", "Male", true));
        persons.add(new Person(2, "Jane Smith", "9876543210", "jane@email.com", "456 Oak Ave", "Female", true));
        persons.add(new Person(3, "Bob Wilson", "5551234567", "bob@email.com", "789 Pine Rd", "Male", false));
        return persons;
    }
}