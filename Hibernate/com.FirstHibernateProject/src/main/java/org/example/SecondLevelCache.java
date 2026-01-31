package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session1 = sf.openSession();

        Student s1 = session1.get(Student.class, 2);
        System.out.println(s1);
        session1.close();

        Session session2 = sf.openSession();

        Student s2 = session2.get(Student.class, 2);
        System.out.println(s2);
        session2.close();

    }
}
