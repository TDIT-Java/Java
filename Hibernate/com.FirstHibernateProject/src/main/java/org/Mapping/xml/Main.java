package org.Mapping.xml;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Person person = new Person(1, "Pradeep", "Ichalkaranji");

        session.save(person);
        tx.commit();
        session.close();
    }
}
