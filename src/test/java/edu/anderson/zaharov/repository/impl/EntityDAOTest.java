package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.FeedBack;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EntityDAOTest {

    @BeforeAll
    static void init() {

        PoolConnector instance = PoolConnector.getInstance();
        try (Connection con = instance.getConnection()) {
            ScriptRunner sr = new ScriptRunner(con);
            Reader reader = null;
            try {
                reader = new BufferedReader(new FileReader("D:\\java\\anderson\\src\\test\\resources\\sql\\testInit.sql"));
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
            }
            sr.runScript(reader);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }


    @Test
    @Order(1)
    void save() {

        log.info("*** Test save DAO *** ---> START");
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
        log.info("*** Test save DAO *** ---> FINISH");
    }

    @Test
    @Order(2)
    void get() {

        log.info("*** Test get DAO *** ---> START");
        try {
            assertEquals("test", new FeedBackDAO().get(3L).getText());
            assertEquals("test", new FeedBackDAO().get(4L).getText());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test get DAO *** ---> FINISH");
    }

    @Test
    @Order(3)
    void update() {

        log.info("*** Test update DAO *** ---> START");
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
        log.info("*** Test update DAO *** ---> FINISH");
    }

    @Test
    @Order(4)
    void delete() {

        log.info("*** Test delete DAO *** ---> START");
        try {
            new TeamDAO().delete(5L);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test delete DAO *** ---> FINISH");
    }
}