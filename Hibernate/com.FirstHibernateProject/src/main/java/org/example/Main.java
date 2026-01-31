package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello and welcome!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student st = new Student(1, "Pradeep", "Ichalkaranji");
        System.out.println(st);

        Address ad = new Address();
        ad.setStreet("XYZ");
        ad.setCity("Berlin");
        ad.setOpen(true);
        ad.setX(5.5);
        ad.setAddedDate(new Date());

        FileInputStream fis = new FileInputStream("src/main/resources/image.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();

        System.out.println("Done...");
    }
}
