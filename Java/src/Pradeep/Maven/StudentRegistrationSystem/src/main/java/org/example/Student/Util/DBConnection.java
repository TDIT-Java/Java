package org.example.Student.Util;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
                    Properties props = new Properties();
                    props.load(input);

                    String url = props.getProperty("db.url");
                    String username = props.getProperty("db.username");
                    String password = props.getProperty("db.password");

                    connection = DriverManager.getConnection(url, username, password);
                    System.out.println("Database connected successfully!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
