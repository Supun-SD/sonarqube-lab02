package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    // SECURITY ISSUE: Hardcoded credentials FIXED
    private String password = System.getenv("DB_PASSWORD");

    // Protected method to allow mocking in tests
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password);
    }

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws SQLException {

        try (Connection conn = getConnection();
                PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE name = ?")) {

            st.setString(1, username);
            st.executeQuery();
        }
    }

    // EVEN WORSE: another SQL injection
    public void deleteUser(String username) throws SQLException {
        try (Connection conn = getConnection();
                PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.execute();
        }
    }

}
