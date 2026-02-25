package Pradeep.Java8.RealTimeExampleEmp;

import java.util.*;
import java.util.stream.*;

public class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // How many male and female employees are there in the organization
        Map<String, Long> countOfMaleFemaleEmpInOrg = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("male and female employees are there in the organization: \n" + countOfMaleFemaleEmpInOrg);

        System.out.println("--------------------------------------------------------------------------");

        // Print the name of all departments in the organization
        System.out.println("All departments in the organization");
        employeeList.stream().map(employee -> employee.getDepartment()).distinct().forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------");


        // What is the average age of male and female employees?
        Map<String, Double> avgAgeOfEmpInOrg = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average age of male and female employees : \n" + avgAgeOfEmpInOrg);

        System.out.println("--------------------------------------------------------------------------");

        // Get the details of highest paid employee in the organization?
        Employee highestSalaryEmp = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println("Highest salary employee is \n" + highestSalaryEmp);

        System.out.println("--------------------------------------------------------------------------");

        // Get the names of all employees who have joined after 2015
        List<String> namesOfEmpJoinedAfter2015 = employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());
        System.out.println("Names of all employees who have joined after 2015 \n" + namesOfEmpJoinedAfter2015);

        System.out.println("--------------------------------------------------------------------------");

        // Count the number of employees in each department?
        Map<String, Long> numberOfEmployeesInEachDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Set<Map.Entry<String, Long>> entrySet = numberOfEmployeesInEachDepartment.entrySet();
        System.out.println("Number of employees in each department");
        for (Map.Entry<String, Long> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("--------------------------------------------------------------------------");

        // What is the average salary of each department?
        Map<String, Double> averageSalaryOfEachDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        Set<Map.Entry<String, Double>> entrySet1 = averageSalaryOfEachDepartment.entrySet();
        System.out.println("Average salary of each department");
        for (Map.Entry<String, Double> entry : entrySet1) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("--------------------------------------------------------------------------");

        // Get the details of youngest male employee in the product development department?
        Employee youngMaleEmp = employeeList.stream().filter(emp -> emp.getGender().equals("Male") && emp.getDepartment().equals("Product Development")).min(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println("Young male employee is \n" + youngMaleEmp);

        System.out.println("--------------------------------------------------------------------------");

        // Who has the most working experience in the organization?
        Employee mostWorkingExpEmp = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();
        System.out.println("Most working employee is \n" + mostWorkingExpEmp);

        System.out.println("--------------------------------------------------------------------------");

        // How many male and female employees are there in the sales and marketing team?
        Map<String, Long> maleFemaleInSalesAndMarketing = employeeList.stream().filter(emp -> emp.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Male and female employees are there in the sales and marketing team are \n" + maleFemaleInSalesAndMarketing);

        System.out.println("--------------------------------------------------------------------------");

        // What is the average salary of male and female employees?
        Map<String, Double> avgSalaryOfMaleAndFemaleEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary of male and female employees \n" + avgSalaryOfMaleAndFemaleEmp);

        System.out.println("--------------------------------------------------------------------------");

        // List down the names of all employees in each department?
        Map<String, List<Employee>> namesOfAllEmpInAllDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entrySet2 = namesOfAllEmpInAllDept.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entrySet2) {
            System.out.println("*****" + entry.getKey() + "*****");
            List<Employee> emp = entry.getValue();
            for (Employee e : emp) {
                System.out.println(e.getName());
            }
        }

        System.out.println("--------------------------------------------------------------------------");

        // What is the average salary and total salary of the whole organization
        DoubleSummaryStatistics emps = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Total Salray : " + emps.getSum());
        System.out.println("Average Salary : " + emps.getAverage());

        System.out.println("--------------------------------------------------------------------------");

        // Find Second highest Salary in and organization
        Employee secondHighSalEmp = employeeList.stream().map(Employee::getSalary).
                sorted(Comparator.reverseOrder()).distinct().skip(1).
                flatMap(salary -> employeeList.stream().
                        filter(emp -> emp.getSalary() == salary)).findFirst().get();
        System.out.println("Second High salary employee is \n" + secondHighSalEmp);

        System.out.println("--------------------------------------------------------------------------");

        // Separate the employees who are younger or equal to 25 years from those employees
        // who are older than 25 years.
        Map<Boolean, List<Employee>> empsYoungerAndOlderThan25 = employeeList.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() >= 25));
        System.out.println("Separate the employees who are younger or equal to 25 years from those employees\n" +
                "who are older than 25 years " + empsYoungerAndOlderThan25);

        System.out.println("--------------------------------------------------------------------------");



    }
}
