package org.SpringOrm.Dao;

import javax.transaction.Transactional;

import org.SpringOrm.Entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.*;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student) {
        Integer i = (Integer) hibernateTemplate.save(student);
        return i;
    }

    public Student getStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> students = hibernateTemplate.loadAll(Student.class);
        return students;
    }

    @Transactional
    public void updateStudent(Student student) {
        hibernateTemplate.update(student);
    }

    @Transactional
    public void deleteStudent(int studentId) {
        Student student = hibernateTemplate.get(Student.class, studentId);
        hibernateTemplate.delete(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
