package org.SpringCore.Standalone.Collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("StandaloneCollectionsConfig.xml");
        Person p1 = context.getBean("person1", Person.class);
        System.out.println(p1);
        System.out.println(p1.getFriends().getClass().getName());

        System.out.println("_".repeat(150));

        System.out.println(p1.getFeesStructure());
        System.out.println(p1.getFeesStructure().getClass().getName());

        System.out.println("_".repeat(150));

        System.out.println(p1.getProperties());
        System.out.println(p1.getProperties().getClass().getName());

    }
}
