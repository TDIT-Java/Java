package org.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Question q1 = new Question();
        q1.setQuestion("How are you?");

        Answer a1 = new Answer();
        a1.setAnswer("Good");
        a1.setQuestion(q1);

        Answer a2 = new Answer();
        a2.setAnswer("Fine");
        a2.setQuestion(q1);

        Answer a3 = new Answer();
        a3.setAnswer("Best");
        a3.setQuestion(q1);

        List<Answer> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswers(list);

        session.save(q1);

        tx.commit();

        session.close();
        sf.close();
    }
}
