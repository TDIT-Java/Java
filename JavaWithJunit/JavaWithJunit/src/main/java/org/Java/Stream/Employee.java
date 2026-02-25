package org.Java.Stream;

import java.util.*;
import java.util.stream.*;

public class Employee {
    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String newJoiner;
    private int salary;
    private int rating;

    public Employee() {
    }

    enum ORDER {ASC, DESC}

    public Employee(String empId, String firstName, String lastName, String email, String gender, String newJoiner, int salary, int rating) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.newJoiner = newJoiner;
        this.salary = salary;
        this.rating = rating;
    }

    public String getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getNewJoiner() {
        return newJoiner;
    }

    public int getSalary() {
        return salary;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "empId='" + empId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", newJoiner='" + newJoiner + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                '}' + "\n";
    }

    public static void main(String[] args) {
        Employee emp = new Employee();

        List<Employee> employees = Arrays.asList(
                new Employee("59-385-1088", "Zacharias", "Schwerin", "zchwerin@gmail.com", "Male", "TRUE", 101146, 0),
                new Employee("73-274-6476", "Kyle", "Frudd", "kfrudd1@ovh.net", "Male", "FALSE", 29310, 2),
                new Employee("85-939-9584", "Axe", "Gumb", "agumb2@twitter.com", "Female", "FALSE", 62291, 4),
                new Employee("08-180-8292", "Robinet", "Batterham", "rbatterham3@last.fm", "Male", "FALSE", 142439, 4),
                new Employee("21-825-2623", "Ulick", "Burrel", "uburrel4@google.ru", "Male", "FALSE", 128764, 5),
                new Employee("66-708-5539", "Tailor", "Ridding", "Ridding", "Male", "FALSE", 152924, 4),
                new Employee("81-697-2363", "Joete", "Braybrooke", "jbraybrooke6@prnewswire.com", "Male", "TRUE", 128907, 0),
                new Employee("63-019-1110", "Elroy", "Baverstock", "ebaverstock7@ehow.com", "Female", "TRUE", 2510, 0)
        );

        // filter the employees list with gender as Female
        List<Employee> femaleEmps = emp.filterEmpWithGender(employees);
        System.out.println("Female Employees List : \n" + femaleEmps);

        line();

        // filter the employees list with newJoiner as True
        List<Employee> newJoinerEmpList = emp.newJoinerEmpList(employees);
        System.out.println("New Joiner Employees List : \n" + newJoinerEmpList);

        line();

        // sort the employee list by rating asc
        List<Employee> sortedByRatingEmpListAsc = emp.sortEmpByRating(employees, "ASC");
        System.out.println("Sorted Emp list by ascending order rating : \n" + sortedByRatingEmpListAsc);

        line();

        // sort the employee list by rating desc
        List<Employee> sortedByRatingEmpListDesc = emp.sortEmpByRating(employees, "DESC");
        System.out.println("Sorted Emp list by deasending order rating : \n" + sortedByRatingEmpListDesc);

        line();

        // sort the employee list by both rating and salary
        List<Employee> sortedByRatingAndSalary = emp.sortingByRatingAndSalary(employees);
        System.out.println("Sorted Emp List by Rating and Salary : \n" + sortedByRatingAndSalary);

        line();

        // employees with salary more than 1000
        List<Employee> empsMoreThanOneThousandSalary = emp.empsMoreThanOneThousandSalary(employees);
        System.out.println("Employees More than 1000 Salary : \n" + empsMoreThanOneThousandSalary);

        line();

        // Is all employees have more than 1000 Rs. Salary
        System.out.println("Is all employees have more than 1000 Rs. Salary : ");
        System.out.println("Is all employees have more than 1000 Rs. Salary : " + emp.isAllEmpsHaveMoreThanOneThousandSalary(employees));

        line();

        // Retrieve employee with max salary
        List<Employee> empHavingMaxSalary = emp.empHavingMaxSalary(employees);
        System.out.println("Employees having with Max Salary : \n" + empHavingMaxSalary);

        line();

        // Retrieve employee with max rating
        List<Employee> empHavingMaxRating = emp.empHavingMaxRating(employees);
        System.out.println("Employees having with Max Rating : \n" + empHavingMaxRating);

        line();

//        // Retrieve employee with min salary
        List<Employee> empHavingMinSalary = emp.empHavingMinSalary(employees);
        System.out.println("Employees having with Min Salary : \n" + empHavingMinSalary);

        line();

        // Retrieve employee with min rating
        List<Employee> empHavingMinRating = emp.empHavingMinRating(employees);
        System.out.println("Employees having with Min Rating : \n" + empHavingMinRating);

        line();

        // group all our employees by Gender
        Map<String, List<Employee>> EmpGroupByGender = emp.groupByGender(employees);
        System.out.println("Grouped Employees by Gender : \n");
        EmpGroupByGender.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(System.out::println);
        });
    }

    public List<Employee> filterEmpWithGender(List<Employee> employees) {
        return employees.stream().filter(emp -> emp.getGender().equals("Female")).collect(Collectors.toList());
    }

    public List<Employee> newJoinerEmpList(List<Employee> employees) {
        return employees.stream().filter(emp -> emp.getNewJoiner().equals("TRUE")).collect(Collectors.toList());
    }

    public List<Employee> sortEmpByRating(List<Employee> employees, String order) {
        if (order.equals(ORDER.ASC.toString())) {
            return employees.stream().sorted(Comparator.comparing(Employee::getRating)).collect(Collectors.toList());
        }

        return employees.stream().sorted(Comparator.comparing(Employee::getRating).reversed()).collect(Collectors.toList());
    }

    public List<Employee> sortingByRatingAndSalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getRating).thenComparing(Employee::getSalary)).collect(Collectors.toList());
    }

    public List<Employee> empsMoreThanOneThousandSalary(List<Employee> employees) {
        return employees.stream().filter(emp -> emp.getSalary() > 1000).collect(Collectors.toList());
    }

    public boolean isAllEmpsHaveMoreThanOneThousandSalary(List<Employee> employees) {
        return employees.stream().allMatch(emp -> emp.getSalary() > 1000);
    }

    public List<Employee> empHavingMaxSalary(List<Employee> employees) {
        int maxSalary = employees.stream().mapToInt(Employee::getSalary).max().getAsInt();
        return employees.stream().filter(emp -> emp.getSalary() == maxSalary).collect(Collectors.toList());
    }

    public List<Employee> empHavingMaxRating(List<Employee> employees) {
        int maxRating = employees.stream().mapToInt(Employee::getRating).max().getAsInt();
        return employees.stream().filter(emp -> emp.getRating() == maxRating).collect(Collectors.toList());
    }

    public List<Employee> empHavingMinSalary(List<Employee> employees) {
        int minSalary = employees.stream().mapToInt(Employee::getSalary).min().getAsInt();
        return employees.stream().filter(emp -> emp.getSalary() == minSalary).collect(Collectors.toList());
    }

    public List<Employee> empHavingMinRating(List<Employee> employees) {
        int minRating = employees.stream().mapToInt(Employee::getRating).min().orElseThrow(NoSuchElementException::new);
        return employees.stream().filter(emp -> emp.getRating() == minRating).collect(Collectors.toList());
    }

    public Map<String, List<Employee>> groupByGender(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getGender));
    }

    public static void line() {
        System.out.println("-".repeat(200));
    }
}
