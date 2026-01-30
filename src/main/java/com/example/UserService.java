package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    // SECURITY ISSUE: Hardcoded credentials
    // SECURITY ISSUE: Hardcoded credentials FIXED
    private String password = System.getenv("DB_PASSWORD");

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
                "root", password);
                PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE name = ?")) {

            st.setString(1, username);
            st.executeQuery();
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        logger.info("I am never called");
    }

    // EVEN WORSE: another SQL injection
    public void deleteUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
                "root", password);
                PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.execute();
        }
    }

}
