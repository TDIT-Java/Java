package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EMDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student student = new Student();
        student.setId(2);
        student.setName("Aditya");
        student.setCity("Kolhapur");

        Certificate certificate = new Certificate();
        certificate.setCourse("BSC");
        certificate.setDuration("2 Months");

        student.setCert(certificate);


        Student student1 = new Student();
        student1.setId(3);
        student1.setName("Piyush");
        student1.setCity("Korochi");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("MBA");
        certificate1.setDuration("6 Months");

        student1.setCert(certificate1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);
        session.save(student1);

        tx.commit();

        session.close();
        factory.close();
    }
}
