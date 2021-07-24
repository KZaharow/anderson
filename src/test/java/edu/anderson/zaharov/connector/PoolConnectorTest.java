package edu.anderson.zaharov.connector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PoolConnectorTest {

    @DisplayName("Test poolConnector")
    @Test
    void getSingleToneTestInstance() {

        PoolConnector pc = PoolConnector.getInstance();
        try (Connection c = pc.getConnection()) {
            assertNotNull(c);
        } catch (SQLException e) {
        }
    }
}