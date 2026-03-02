package org.java;

import org.java.dao.EmployeeDao;
import org.java.entity.Employee;
import org.java.jdbcHelpers.utils;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.setName("Pradeep");
        emp.setAge(24);
        emp.setSalary(12000000);
        emp.setDepartment("IT");

        Employee emp2 = new Employee();
        emp2.setName("Mallikarjun");
        emp2.setAge(30);
        emp2.setSalary(14000000);
        emp2.setDepartment("IT");

        Employee emp3 = new Employee();
        emp3.setName("Prathamesh");
        emp3.setAge(24);
        emp3.setSalary(12000000);
        emp3.setDepartment("CS");

        Employee emp4 = new Employee();
        emp4.setName("Jayvardhan");
        emp4.setAge(25);
        emp4.setSalary(13000000);
        emp4.setDepartment("IT");

        Employee emp5 = new Employee();
        emp5.setName("Nikhil");
        emp5.setAge(25);
        emp5.setSalary(1000000);
        emp5.setDepartment("IT");

        Employee emp6 = new Employee();
        emp6.setName("Aditya");
        emp6.setAge(24);
        emp6.setSalary(11000000);
        emp6.setDepartment("ETL");

        try {
            // Insert emps
            EmployeeDao.insertEmp(emp);
            EmployeeDao.insertEmp(emp2);
            EmployeeDao.insertEmp(emp3);
            EmployeeDao.insertEmp(emp4);
            EmployeeDao.insertEmp(emp5);
            EmployeeDao.insertEmp(emp6);

            utils.dashedLine();

            // Display all emps
            EmployeeDao.getAllEmployees().forEach(System.out::println);

            utils.dashedLine();

            // Update emp at id 1
            Employee updateEmp = new Employee();
            updateEmp.setName("Pradeep Parit");
            updateEmp.setId(1);
            EmployeeDao.updateEmp(updateEmp);

            utils.dashedLine();

            // Display Employee at id 1
            Employee empAtOne = EmployeeDao.findById(1);
            System.out.println("Employee at id 1 is : " + empAtOne);

            utils.dashedLine();

            // Delete emp at 5
            EmployeeDao.deleteEmp(5);

            utils.dashedLine();

            // Display all emps
            EmployeeDao.getAllEmployees().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
