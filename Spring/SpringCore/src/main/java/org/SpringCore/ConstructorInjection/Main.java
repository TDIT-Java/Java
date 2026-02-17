package org.SpringCore.ConstructorInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ConstrucInjecConfig.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
