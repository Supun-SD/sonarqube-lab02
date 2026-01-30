package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Test
    void testFindUser() throws SQLException {
        // Create a partial mock or subclass to override getConnection
        UserService userService = new UserService() {
            @Override
            protected Connection getConnection() {
                return connection;
            }
        };

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        userService.findUser("testuser");

        verify(connection).prepareStatement("SELECT * FROM users WHERE name = ?");
        verify(preparedStatement).setString(1, "testuser");
        verify(preparedStatement).executeQuery();
    }

    @Test
    void testDeleteUser() throws SQLException {
        UserService userService = new UserService() {
            @Override
            protected Connection getConnection() {
                return connection;
            }
        };

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        userService.deleteUser("testuser");

        verify(connection).prepareStatement("DELETE FROM users WHERE name = ?");
        verify(preparedStatement).setString(1, "testuser");
        verify(preparedStatement).execute();
    }
}
