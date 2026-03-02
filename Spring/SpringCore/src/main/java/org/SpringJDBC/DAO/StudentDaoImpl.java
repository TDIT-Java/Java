package org.SpringJDBC.DAO;

import org.SpringJDBC.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        String query = "insert into student(name, address) values (?, ?)";
        int result = jdbcTemplate.update(query, student.getName(), student.getAddress());
        return result;
    }

    @Override
    public int change(Student student) {
        String query = "update student set name = ?, address = ? where id = ?";
        int result = jdbcTemplate.update(query, student.getName(), student.getAddress(), student.getId());
        return result;
    }

    @Override
    public int delete(int id) {
        String query = "delete from student where id = ?";
        int result = jdbcTemplate.update(query, id);
        return result;
    }

    @Override
    public Student getStudent(int id) {
        String query = "select * from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = jdbcTemplate.queryForObject(query, rowMapper, id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student";
        List<Student> students = jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
