package com.chokshi.deep.pos_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    static Connection connection;

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/axis_bank";
        String username = "root";
        String password = "admin@123";

        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return connection;
    }
}


