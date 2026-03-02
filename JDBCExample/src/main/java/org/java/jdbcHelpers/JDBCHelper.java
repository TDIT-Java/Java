package org.java.jdbcHelpers;

import java.sql.*;

public class JDBCHelper {
    private Connection connection;

    static {
        try {
            Class.forName(ConfigConstance.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found for DriverName: " + ConfigConstance.DRIVER_NAME);
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(ConfigConstance.URL, ConfigConstance.USERNAME, ConfigConstance.PASSWORD);
        return con;
    }

    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
