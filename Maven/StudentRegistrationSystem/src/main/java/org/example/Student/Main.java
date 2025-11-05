package org.example.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.example.Student.Dao.StudentDAO;
import org.example.Student.Model.Student;
import org.example.Student.Util.DBConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Testing DB connection...");
        Connection conn = DBConnection.getConnection();
        System.out.println(conn != null ? "Connection successful!" : "Connection failed!");


        while (true) {
            System.out.println("\n--- Student Registration System ---");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter first name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    dao.addStudent(new Student(firstName, lastName, email));
                }
                case 2 -> {
                    List<Student> students = dao.getAllStudents();
                    students.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Goodbye!");
                    DBConnection.closeConnection();
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
