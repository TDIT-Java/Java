package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        Student student = session.get(Student.class, 2);
        System.out.println(student);
        System.out.println(session.contains(student));
        System.out.println(student);
        session.close();
    }
}
