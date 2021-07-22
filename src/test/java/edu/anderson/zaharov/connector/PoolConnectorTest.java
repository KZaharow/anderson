package edu.anderson.zaharov.connector;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class PoolConnectorTest {

    @DisplayName("Test poolConnector")
    @Test
    void getSingleToneTestInstance() {

        PoolConnector pc = PoolConnector.getInstance();
        PoolConnector pcUpd = PoolConnector.getInstance();
        Connection cpds = pc.getConnection();
        Connection cpdsUpd = pcUpd.getConnection();
        assertEquals(cpds, cpdsUpd);
    }
}