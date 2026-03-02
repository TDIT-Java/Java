package org.SpringJDBC.DAO;

import org.SpringJDBC.Entity.Student;
import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int delete(int id);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
}
