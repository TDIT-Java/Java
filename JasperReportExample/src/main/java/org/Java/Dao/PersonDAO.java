package org.Java.Dao;

import org.Java.Model.Person;
import org.Java.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        String query = "SELECT id, name, mobile_no, email, address, gender, is_alive FROM persons ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setMobileNo(rs.getString("mobile_no"));
                person.setEmail(rs.getString("email"));
                person.setAddress(rs.getString("address"));
                person.setGender(rs.getString("gender"));
                person.setAlive(rs.getBoolean("is_alive"));
                persons.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public List<Person> getAlivePersons() {
        List<Person> persons = new ArrayList<>();
        String query = "SELECT id, name, mobile_no, email, address, gender, is_alive FROM persons WHERE is_alive = true";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setMobileNo(rs.getString("mobile_no"));
                person.setEmail(rs.getString("email"));
                person.setAddress(rs.getString("address"));
                person.setGender(rs.getString("gender"));
                person.setAlive(rs.getBoolean("is_alive"));
                persons.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }
}