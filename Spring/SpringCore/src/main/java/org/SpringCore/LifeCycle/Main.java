package org.SpringCore.LifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("LifeCycle.xml");

        // registering shut down hook
        context.registerShutdownHook();

        Samosa s1 = (Samosa) context.getBean("s1");
        System.out.println(s1);

        System.out.println("-".repeat(150));

        Pepsi p1 = (Pepsi) context.getBean("p1");
        System.out.println(p1);

        System.out.println("-".repeat(150));

        UsingAnnotations usingAnnotations = (UsingAnnotations) context.getBean("e1");
        System.out.println(usingAnnotations);
    }
}
