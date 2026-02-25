import org.Java.Stream.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class EmployeeTestCases {
    private Employee employee;
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employee = new Employee();

        employees = Arrays.asList(
                new Employee("59-385-1088", "Zacharias", "Schwerin", "zchwerin@gmail.com", "Male", "TRUE", 101146, 0),
                new Employee("73-274-6476", "Kyle", "Frudd", "kfrudd1@ovh.net", "Male", "FALSE", 29310, 2),
                new Employee("85-939-9584", "Axe", "Gumb", "agumb2@twitter.com", "Female", "FALSE", 62291, 4),
                new Employee("08-180-8292", "Robinet", "Batterham", "rbatterham3@last.fm", "Male", "FALSE", 142439, 4),
                new Employee("21-825-2623", "Ulick", "Burrel", "uburrel4@google.ru", "Male", "FALSE", 128764, 5),
                new Employee("66-708-5539", "Tailor", "Ridding", "Ridding", "Male", "FALSE", 152924, 4),
                new Employee("81-697-2363", "Joete", "Braybrooke", "jbraybrooke6@prnewswire.com", "Male", "TRUE", 128907, 0),
                new Employee("63-019-1110", "Elroy", "Baverstock", "ebaverstock7@ehow.com", "Female", "TRUE", 2510, 0)
        );
    }

    // Test case for employees list with gender as Female
    @Test
    @DisplayName("Should return only Female Employees")
    public void testFilterEmpWithGender() {
        List<Employee> result = employee.filterEmpWithGender(employees);

        assertAll("Validate Female Employees",
                () -> assertNotNull(result),
                () -> assertTrue(result.stream()
                        .allMatch(emp -> "Female".equals(emp.getGender())))
        );
    }

    @Test
    @DisplayName("Should return only New Joiner Employees")
    public void testNewJoinerEmpList() {
        List<Employee> result = employee.newJoinerEmpList(employees);

        assertAll("Validate New Joiner Employees",
                () -> assertNotNull(result),
                () -> assertTrue(result.stream()
                        .allMatch(emp -> "TRUE".equals(emp.getNewJoiner())))
        );
    }

    @Test
    @DisplayName("Should return only Sorted Employees By Rating")
    public void testSortEmpByRating() {
        List<Employee> result = employee.sortEmpByRating(employees, "ASC");

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(8, result.size()),
                () -> assertEquals(1, result.get(0).getRating()),
                () -> assertEquals(2, result.get(1).getRating()),
                () -> assertEquals(3, result.get(2).getRating()),
                () -> assertEquals(5, result.get(3).getRating())
        );
    }

    @Test
    @DisplayName("Should sort employees by rating in descending order")
    void shouldSortEmployeesByRatingDescending() {
        List<Employee> result = employee.sortEmpByRating(employees, "DESC");

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(5, result.get(0).getRating()),
                () -> assertEquals(3, result.get(1).getRating()),
                () -> assertEquals(2, result.get(2).getRating()),
                () -> assertEquals(1, result.get(3).getRating())
        );
    }

    @Test
    public void testSortingByRatingAndSalary() {
        List<Employee> result = employee.sortingByRatingAndSalary(employees);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(4, result.size()),

                // Rating 1 first
                () -> assertEquals(1, result.get(0).getRating()),

                // Rating 2 second
                () -> assertEquals(2, result.get(1).getRating()),

                // Rating 3 sorted by salary
                () -> assertEquals(3, result.get(2).getRating()),
                () -> assertEquals(3000, result.get(2).getSalary()),

                () -> assertEquals(3, result.get(3).getRating()),
                () -> assertEquals(5000, result.get(3).getSalary())
        );
    }

    @Test
    @DisplayName("Should return employees having salary > 1000")
    void testEmpsMoreThanOneThousandSalary() {

        List<Employee> result = employee.empsMoreThanOneThousandSalary(employees);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(3, result.size()),
                () -> assertTrue(result.stream()
                        .allMatch(emp -> emp.getSalary() > 1000))
        );
    }

    @Test
    @DisplayName("Should return false if all employees do not have salary > 1000")
    void testIsAllEmpsHaveMoreThanOneThousandSalary() {

        boolean result = employee.isAllEmpsHaveMoreThanOneThousandSalary(employees);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return employee(s) having maximum salary")
    void testEmpHavingMaxSalary() {

        List<Employee> result = employee.empHavingMaxSalary(employees);

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(7000, result.get(0).getSalary()),
                () -> assertEquals("Alice", result.get(0).getFirstName())
        );
    }

    @Test
    @DisplayName("Should return employees having maximum rating")
    void testEmpHavingMaxRating() {

        List<Employee> result = employee.empHavingMaxRating(employees);

        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertTrue(result.stream()
                        .allMatch(emp -> emp.getRating() == 5))
        );
    }

    @Test
    @DisplayName("Should return employees having minimum salary")
    void testEmpHavingMinSalary() {

        List<Employee> result = employee.empHavingMinSalary(employees);

        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertTrue(result.stream()
                        .allMatch(emp -> emp.getSalary() == 1000))
        );
    }

    @Test
    @DisplayName("Should return employee having minimum rating")
    void testEmpHavingMinRating() {

        List<Employee> result = employee.empHavingMinRating(employees);

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(1, result.get(0).getRating()),
                () -> assertEquals("David", result.get(0).getFirstName())
        );
    }

    @Test
    @DisplayName("Should group employees by gender")
    void testGroupByGender() {

        Map<String, List<Employee>> result = employee.groupByGender(employees);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(2, result.size()),
                () -> assertTrue(result.containsKey("Male")),
                () -> assertTrue(result.containsKey("Female")),
                () -> assertEquals(3, result.get("Male").size()),
                () -> assertEquals(2, result.get("Female").size())
        );
    }
}
