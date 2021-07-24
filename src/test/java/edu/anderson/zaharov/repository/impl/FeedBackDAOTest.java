package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.entity.FeedBack;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
class FeedBackDAOTest {


    @Test
    @Order(1)
    void save() {

        FeedBack feedBack = new FeedBack();
        feedBack.setText("test");
        feedBack.setDate(new Date());
        FeedBackDAO feedBackDAO = new FeedBackDAO();
        try {
            Long id1 = feedBackDAO.save(feedBack);
            Long id2 = feedBackDAO.save(feedBack);
            assertEquals(1, id2 - id1);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    @Order(2)
    void get() {

        try {
            assertEquals("Замечательно справился", new FeedBackDAO().get(1L).getText());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Test
    void update() {

        FeedBack feedBack = new FeedBack();
        feedBack.setId(3L);
        feedBack.setText("upd");
        feedBack.setDate(new Date());
        try {
            long id = new FeedBackDAO().update(feedBack);
            assertEquals(3, id);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    void delete() {

        try {
            new FeedBackDAO().delete(3L);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}