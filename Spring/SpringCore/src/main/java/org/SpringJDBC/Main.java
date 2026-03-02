package org.SpringJDBC;

import org.SpringJDBC.DAO.StudentDao;
import org.SpringJDBC.Entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        // Insert
//        Student student = new Student();
//        student.setName("Abc");
//        student.setAddress("Pqr");
//
//        int result = studentDao.insert(student);
//        System.out.println("Students added..." + result);

        // Update
//        Student student = new Student();
//        student.setId(2);
//        student.setName("Jack");
//        student.setAddress("Us");
//
//        int result = studentDao.change(student);
//        System.out.println("Rows updated..." +result);

        // Delete
//        int result = studentDao.delete(3);
//        System.out.println("Rows deleted..." +result);

        // get Student id with 1
//        Student student = studentDao.getStudent(1);
//        System.out.println("Student with id 1 is..." + student);

        // get all students
        List<Student> students = studentDao.getAllStudents();
        students.forEach(System.out::println);

    }
}
