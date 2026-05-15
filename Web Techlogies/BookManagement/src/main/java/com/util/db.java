package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

    private static final String URL = "jdbc:mysql://localhost:3306/bookdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected");
            return conn;

        } catch(ClassNotFoundException e) {
            throw new IllegalStateException("MySQL JDBC driver not found. Add mysql-connector-j to WEB-INF/lib.", e);
        } catch(SQLException e) {
            throw new IllegalStateException("Unable to connect to the bookdb MySQL database.", e);
        } catch(Exception e) {
            throw new IllegalStateException("Unexpected database connection error.", e);
        }
    }
}
