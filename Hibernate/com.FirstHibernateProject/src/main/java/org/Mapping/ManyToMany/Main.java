package org.Mapping.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Emp ep1 = new Emp();
        Emp ep2 = new Emp();

        ep1.setName("Abc");
        ep2.setName("Xyz");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setProjectName("Project1");
        p2.setProjectName("Project2");

        List<Emp> emp = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        emp.add(ep1);
        emp.add(ep2);

        projects.add(p1);
        projects.add(p2);

        ep1.setProjects(projects);
        p2.setEmp(emp);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p1);
        session.save(p2);
        session.save(ep1);
        session.save(ep2);

        tx.commit();
        session.close();
        factory.close();

    }
}
