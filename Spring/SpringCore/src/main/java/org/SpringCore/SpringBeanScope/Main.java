package org.SpringCore.SpringBeanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeanScope.xml");

        // Singleton
        TestAnnotation testAnnotationBean1 = context.getBean("testAnnotation",TestAnnotation.class);
//        System.out.println(testAnnotationBean1.hashCode());

        TestAnnotation testAnnotationBean2 = context.getBean("testAnnotation",TestAnnotation.class);
//        System.out.println(testAnnotationBean2.hashCode());

        // Prototype
        TestByBeanScope testByBeanScope = context.getBean("testByBeanScope",TestByBeanScope.class);
        System.out.println(testByBeanScope.hashCode());

        TestByBeanScope testByBeanScope1 = context.getBean("testByBeanScope",TestByBeanScope.class);
        System.out.println(testByBeanScope1.hashCode());
    }
}
