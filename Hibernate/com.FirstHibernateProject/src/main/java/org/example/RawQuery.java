package org.example;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class RawQuery {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String query = "from Student as s where s.id=:i and s.name=:x";
        Query q = session.createQuery(query);
        q.setParameter("i", 1);
        q.setParameter("x", "Abc");

        List<Student> students = q.list();

        for (Student s : students)
            System.out.println("Id: " + s.getId() + " \nName: " + s.getName() + " \nCity: " + s.getCity() + " \nCourse: " + s.getCert().getCourse());

        System.out.println("---------------------------------------------------------------");

        // Delete Query
//        Query q2 = session.createQuery("delete Student where id=:i");
//        q2.setParameter("i", 1);
//        int r = q2.executeUpdate();
//        System.out.println("Total deleted rows:" + r);

        // Update Query
        Query q3 = session.createQuery("update Student set city=:x where id=:y");
        q3.setParameter("x", "Latur");
        q3.setParameter("y", 3);
        int updatedRows = q3.executeUpdate();
        System.out.println("Total updated rows:" + updatedRows);

        tx.commit();

        System.out.println("----------------------------------------------------------------");
        // JOIN
        Query q4 = session.createQuery("select q.id, q.question, a.id, a.answer from Question as q Inner Join q.answerId as a");
        List<Object[]> list = q4.getResultList();
        for (Object[] obj : list) {
            System.out.println(Arrays.toString(obj));
        }

        session.close();
        factory.close();
    }
}
