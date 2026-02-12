package org.example.Dao;

import jakarta.persistence.EntityManager;
import org.example.Entity.Student;
import org.example.util.*;

import java.util.*;

public class StudentDao {
    public void saveStudent(Student student) {
        EntityManager em = Session.beginTransaction();

        Integer id = student.getId();

        if (id == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        try {
            Session.commitTransaction(em);
        } catch (IllegalStateException e) {
            Session.rollbackTransaction(em);
            Session.closeEntityManager(em);
            System.out.println("Caught Exception: " + e.getMessage());
            e.printStackTrace();
        }

        if (em.isOpen()) {
            Session.closeEntityManager(em);
        }
    }

    public Student getStudentById(int id) {
        EntityManager em = Session.createEntityManager();
        Student student = em.find(Student.class, id);

        if (em.isOpen()) {
            Session.closeEntityManager(em);
        }

        return student;
    }

    public List<Student> getAllStudents() {
        EntityManager em = Session.createEntityManager();
        List<Student> students = em.createNativeQuery("SELECT * FROM student", Student.class).getResultList();

        if (em.isOpen()) {
            Session.closeEntityManager(em);
        }

        return students;
    }

    public List<Student> getStudentsByName(String name) {
        EntityManager em = Session.createEntityManager();
        List<Student> student = em.createNativeQuery("SELECT * FROM student WHERE name = :name", Student.class).setParameter("name", name).getResultList();

        if (em.isOpen()) {
            Session.closeEntityManager(em);
        }

        return student;
    }

    public void updateStudent(int id, String dept) {
        EntityManager em = Session.beginTransaction();

        Student student = em.find(Student.class, id);
        if (student != null) {
            student.setDepartment(dept);
        }

        try {
            Session.mergeTransaction(em, student);
            Session.commitTransaction(em);
        } catch (IllegalStateException | IllegalArgumentException e) {
            Session.rollbackTransaction(em);
            Session.closeEntityManager(em);
            System.out.println("Caught Exception: " + e.getMessage());
            e.printStackTrace();
        }

        if (em.isOpen()) {
            Session.closeEntityManager(em);
        }
    }

    public void deleteStudent(int id) {
        EntityManager em = Session.beginTransaction();

        try {
            Student student = em.find(Student.class, id);

            if (student != null) {
                em.remove(student);
            }

            Session.commitTransaction(em);
        } catch (IllegalStateException | IllegalArgumentException e) {
            Session.rollbackTransaction(em);
            Session.closeEntityManager(em);
            System.out.println("Caught Exception: " + e.getMessage());
            e.printStackTrace();
        }

        if (em.isOpen()) {
            Session.closeEntityManager(em);
        }
    }
}
