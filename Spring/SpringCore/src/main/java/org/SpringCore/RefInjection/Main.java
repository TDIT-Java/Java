package org.SpringCore.RefInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("refConfig.xml");
        A a = (A) context.getBean("aRef");
        System.out.println(a.getX());
        System.out.println(a.getObj().getY());
        System.out.println(a);
    }
}
