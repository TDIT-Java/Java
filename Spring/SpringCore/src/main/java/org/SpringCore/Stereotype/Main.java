package org.SpringCore.Stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("StereotypeConfig.xml");
        Student s1 = context.getBean("student", Student.class);
        System.out.println(s1);
        System.out.println(s1.getAddress());
        System.out.println(s1.getAddress().getClass().getName());
    }
}
