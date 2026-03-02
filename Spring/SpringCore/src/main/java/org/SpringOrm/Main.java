package org.SpringOrm;

import org.SpringOrm.Dao.StudentDao;
import org.SpringOrm.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springOrmConfig.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(4,"Aditya", "Ichalkaranji");
//        int result = studentDao.insert(student);

//        System.out.println("Rows added..." +result);

        Student s1 = studentDao.getStudent(1);
        System.out.println("Student at 1 : " + s1);

        List<Student> students = studentDao.getAllStudents();
        System.out.println("All students:");
        students.forEach(System.out::println);

        Student student = studentDao.getStudent(1);
        student.setName("Pradeep Parit");

        studentDao.updateStudent(student);

        studentDao.deleteStudent(2);

    }
}
