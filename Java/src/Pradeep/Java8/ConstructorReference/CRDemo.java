package Pradeep.Java8.ConstructorReference;

import java.util.function.*;
import java.util.*;

class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

}

interface Stud {
    public void setStudentDetails(int rollNo, String name);
}

public class CRDemo {
    public static void main(String[] args) {
        Stud s = Student::new;
        s.setStudentDetails(1, "XYZ");

        // Another Method to create object of Student Class
        BiFunction<Integer, String, Student> studentFactory = Student::new;

        List<Student> students = new ArrayList<>();

        students.add(studentFactory.apply(1, "Pradeep"));
        students.add(studentFactory.apply(2, "Amit"));
        students.add(studentFactory.apply(3, "Rohit"));
        students.add(studentFactory.apply(4, "Kiran"));

        Consumer<Student> printStudents = student -> System.out.println("Roll No : " + student.getRollNo() + " and Name is " + student.getName());
        students.forEach(printStudents);

    }
}
