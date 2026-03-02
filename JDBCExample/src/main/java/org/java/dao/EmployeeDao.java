package org.java.dao;

import org.java.entity.Employee;
import org.java.jdbcHelpers.JDBCHelper;

import java.sql.*;
import java.util.*;

public class EmployeeDao {
    public static final String INSERT = "INSERT INTO public.employee(name, age, salary, department) VALUES (?, ?, ?, ?)";
    public static final String FIND_BY_ID = "SELECT * FROM public.employee WHERE id = ?";
    public static final String SELECT_ALL = "SELECT * FROM public.employee";
    public static final StringBuilder UPDATE = new StringBuilder("UPDATE employee SET ");
    public static final String DELETE = "DELETE FROM public.employee WHERE id = ?";

    public static void insertEmp(Employee emp) throws SQLException {
        PreparedStatement ps = null;

        try (Connection conn = JDBCHelper.getConnection()) {
            if (conn == null) {
                System.out.println("Not Connecting to the database, Please check your database connection");
                return;
            }

            conn.setAutoCommit(false);
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, emp.getName());
            ps.setInt(2, emp.getAge());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getDepartment());

            ps.execute();
            System.out.println("Employee inserted successfully...\n" + ps.toString());
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCHelper.closePreparedStatement(ps);
        }
    }

    public static Employee findById(long id) throws SQLException {
        Employee emp = new Employee();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try (Connection conn = JDBCHelper.getConnection()) {
            if (conn == null) {
                System.out.println("Not Connecting to the database, Please check your database connection");
                return emp;
            }

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDepartment(rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCHelper.closeResultSet(rs);
            JDBCHelper.closePreparedStatement(ps);
        }

        return emp;
    }

    public static List<Employee> getAllEmployees() throws SQLException {
        List<Employee> emp = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = JDBCHelper.getConnection()) {
            if (conn == null) {
                System.out.println("Not Connecting to the database, Please check your database connection");
                return emp;
            }

            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp1 = new Employee();
                emp1.setId(rs.getLong("id"));
                emp1.setName(rs.getString("name"));
                emp1.setAge(rs.getInt("age"));
                emp1.setSalary(rs.getDouble("salary"));
                emp1.setDepartment(rs.getString("department"));
                emp.add(emp1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCHelper.closeResultSet(rs);
            JDBCHelper.closePreparedStatement(ps);
        }

        return emp;
    }

    public static void updateEmp(Employee emp) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCHelper.getConnection();

            if (conn == null) {
                System.out.println("Not Connecting to the database, Please check your database connection");
                return;
            }

            conn.setAutoCommit(false);

            List<Object> params = new ArrayList<>();

            if (emp.getName() != null && !emp.getName().isEmpty()) {
                UPDATE.append("name = ?, ");
                params.add(emp.getName());
            }

            if (emp.getAge() > 0) {
                UPDATE.append("age = ?, ");
                params.add(emp.getAge());
            }

            if (emp.getSalary() > 0) {
                UPDATE.append("salary = ?, ");
                params.add(emp.getSalary());
            }

            if (emp.getDepartment() != null && !emp.getDepartment().isEmpty()) {
                UPDATE.append("department = ?, ");
                params.add(emp.getDepartment());
            }

            if (params.isEmpty()) {
                System.out.println("No fields to update.");
                return;
            }

            UPDATE.delete(UPDATE.length() - 2, UPDATE.length());

            UPDATE.append(" WHERE id = ?");
            params.add(emp.getId());

            ps = conn.prepareStatement(UPDATE.toString());

            int index = 1;
            for (Object param : params) {
                ps.setObject(index++, param);
            }

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee updated successfully...");
            } else {
                System.out.println("Employee not found.");
            }

            conn.commit();

        } catch (SQLException e) {

            if (conn != null) {
                conn.rollback();
            }
            throw e;

        } finally {
            JDBCHelper.closePreparedStatement(ps);
            JDBCHelper.closeConnection(conn);
        }
    }

    public static void deleteEmp(long id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCHelper.getConnection();
            if (conn == null) {
                System.out.println("Not Connecting to the database, Please check your database connection");
                return;
            }

            conn.setAutoCommit(false);
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id);
            ps.execute();
            System.out.println("Employee deleted successfully...\n" + ps.toString());
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCHelper.closePreparedStatement(ps);
            JDBCHelper.closeConnection(conn);
        }
    }
}
