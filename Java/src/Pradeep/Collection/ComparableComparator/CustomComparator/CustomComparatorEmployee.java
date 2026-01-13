package Pradeep.Collection.ComparableComparator.CustomComparator;

import java.util.*;

class Employee {
    // Employee class Properties
    private int id;
    private String fName;
    private String lName;
    private String dept;
    private int salary;

    // Parameterised Constructor
    public Employee(int id, String fName, String lName, String dept, int salary) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.dept = dept;
        this.salary = salary;
    }

    // Getting employee ID
    public int getId() {
        return id;
    }

    // Getting first name
    public String getfName() {
        return fName;
    }

    // Getting last name
    public String getlName() {
        return lName;
    }

    // Getting department
    public String getDept() {
        return dept;
    }

    // Getting salary
    public int getSalary() {
        return salary;
    }

    // Overriding toString method of object class to show object properties
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

// Sort by first name with implementing Comparator and overriding compare
class fNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getfName().compareTo(o2.getfName());
    }
}

// Sort by Department name with implementing Comparator and overriding compare
class deptComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getDept().compareTo(o2.getDept());
    }
}

// Sort by Salary with implementing Comparator and overriding compare
class salaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}

public class CustomComparatorEmployee {
    public static void main(String[] args) {
        // Creating Objects for Employee class
        Employee e1 = new Employee(3, "XYZ", "XYZ", "CS", 70000);
        Employee e2 = new Employee(1, "PQR", "PQR", "IT", 5000);
        Employee e3 = new Employee(2, "ABC", "PQR", "AIML", 100000);

        // Creating ArrayList to add all employees and perform sorting
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);


        System.out.println("Before Sorting Employee List: " + employees);

        // Sorting by ID using Anonymous class
        Comparator<Employee> c = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getId() - o2.getId();
            }
        };

        Collections.sort(employees, c);
        System.out.println("After Sorting Employee List by ID: " + employees);

        // Sorting by first name
        Collections.sort(employees, new fNameComparator());

        System.out.println("After Sorting Employee List by first name: " + employees);

        // Sorting by dept
        Collections.sort(employees, new deptComparator());

        System.out.println("After Sorting Employee List by Dept. name: " + employees);

        // Sorting by salary
        Collections.sort(employees, new salaryComparator());

        System.out.println("After Sorting Employee List by Salary: " + employees);

    }
}
