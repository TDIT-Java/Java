package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlPagination {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Student> query = session.createQuery("from Student");
        query.setFirstResult(5);
        query.setMaxResults(5);

        List<Student> list = query.list();
        list.forEach(System.out::println);

        session.close();
        sessionFactory.close();
    }
}
