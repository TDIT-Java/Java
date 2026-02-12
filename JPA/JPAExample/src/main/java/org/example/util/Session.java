package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Entity.Student;

public class Session {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");

    public static EntityManager beginTransaction() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void commitTransaction(EntityManager em) {
        em.getTransaction().commit();
    }

    public static void rollbackTransaction(EntityManager em) {
        em.getTransaction().rollback();
    }

    public static void mergeTransaction(EntityManager em, Student student) {
        em.merge(student);
    }

    public static void closeEntityManager(EntityManager em) {
        em.close();
    }
}
