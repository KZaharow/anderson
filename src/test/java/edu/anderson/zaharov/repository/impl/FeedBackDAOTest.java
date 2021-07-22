package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.FeedBack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FeedBackDAOTest {

    private Connection connection;

    @BeforeAll
    void init(){

        PoolConnector poolConnector = PoolConnector.getInstance();
        connection = poolConnector.getConnection();
    }

    @Test
    void save() {

        FeedBack feedBack = new FeedBack();
        feedBack.setText("test");
        feedBack.setDate(new Date());
        FeedBackDAO feedBackDAO = new FeedBackDAO();
        try {
            feedBackDAO.save(feedBack);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}