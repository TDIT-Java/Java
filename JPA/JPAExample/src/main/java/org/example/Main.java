package org.example;

import org.example.Dao.StudentDao;
import org.example.Entity.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        Student s1 = new Student(1, "Pradeep", "pradeepparit2001@gmail.com", "IT");
        Student s2 = new Student(2, "Aditya", "aditya@gmail.com", "MCA");

        studentDao.saveStudent(s1);
        studentDao.saveStudent(s2);

        Student idOneStud = studentDao.getStudentById(1);
        System.out.println("Student at Id 1 is : " + idOneStud);

        List<Student> students = studentDao.getAllStudents();
        System.out.println("--------------------------All Student List--------------------------");
        students.stream().forEach(System.out::println);

        List<Student> studentsByName = studentDao.getStudentsByName("Pradeep");
        System.out.println("Students getting by name 'Pradeep' : ");
        studentsByName.stream().forEach(System.out::println);

        studentDao.updateStudent(1, "CS");
        System.out.println("After Updating student with dept 'CS'");
        List<Student> updatedStudents = studentDao.getAllStudents();
        System.out.println("--------------------------All Student List--------------------------");
        updatedStudents.stream().forEach(System.out::println);

        studentDao.deleteStudent(1);
        System.out.println("After Deleting student with id 1");


        List<Student> studentsList = studentDao.getAllStudents();

        if (studentsList.size() > 0) {
            System.out.println("--------------------------All Student List--------------------------");
            studentsList.stream().forEach(System.out::println);
        }

    }
}
