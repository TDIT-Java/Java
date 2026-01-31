package org.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestion("What is your name?");

        Answer a1 = new Answer();
        a1.setAnswer("ABC");
        a1.setQuestion(q1);

        Answer a2 = new Answer();
        a2.setAnswer("DEF");
        a2.setQuestion(q1);

        Answer a3 = new Answer();
        a3.setAnswer("GHI");
        a3.setQuestion(q1);

        List<Answer> list = new ArrayList();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswers(list);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(a1);
        session.save(a2);
        session.save(a3);


        // Getting Question and Answer
        Question qa = (Question) session.get(Question.class, 1);
        System.out.println(qa.getQuestion());
        for(Answer a : qa.getAnswers()){
            System.out.println(a.getAnswer());
        }

        System.out.println(qa.getAnswers().size());

        tx.commit();
        session.close();
        factory.close();
    }
}
