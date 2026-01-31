package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.*;

public class SqlExample {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        String query = "select * from student";
        NativeQuery nq = session.createNativeQuery(query);
        List<Object[]> list = nq.list();

        list.forEach(obj -> System.out.println(obj[0] + " : " + obj[1]));
    }
}
