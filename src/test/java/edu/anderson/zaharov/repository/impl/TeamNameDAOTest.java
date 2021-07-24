package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.TeamName;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamNameDAOTest {

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
        TeamName teamName = new TeamName();
        teamName.setName("test");
        TeamNameDAO teamNameDAO = new TeamNameDAO();
        try {
            Long id1 = teamNameDAO.save(teamName);
            Long id2 = teamNameDAO.save(teamName);
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
            assertEquals("test", new TeamNameDAO().get(3L).getName());
            assertEquals("test", new TeamNameDAO().get(4L).getName());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test get DAO *** ---> FINISH");
    }

    @Test
    @Order(3)
    void update() {

        log.info("*** Test update DAO *** ---> START");
        TeamName teamName = new TeamName();
        teamName.setId(3L);
        teamName.setName("upd");
        try {
            long id = new TeamNameDAO().update(teamName);
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
            new TeamNameDAO().delete(5L);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test delete DAO *** ---> FINISH");
    }
}