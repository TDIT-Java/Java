package org.Criteria;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class CriteriaExample {
    public static void main(String[] args) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();

//        Criteria c = session.createCriteria(Student.class);
//        c.add(Restrictions.eq("cert.course", "java"));
//        c.add(Restrictions.like("cert.course", "java%"));
//        c.add(Restrictions.gt("id", 15));
//        c.add(Restrictions.lt("id", 15));

//        List<Student> student = c.list();
//        student.forEach(System.out::println);

        session.close();
    }
}
