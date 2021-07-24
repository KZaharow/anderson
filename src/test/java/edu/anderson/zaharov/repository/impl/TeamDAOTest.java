package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.Team;
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
class TeamDAOTest {

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
        Team team = new Team();
        team.setTeamNameId(3L);
        team.setEmployerId(3L);
        TeamDAO teamDAO = new TeamDAO();
        try {
            Long id1 = teamDAO.save(team);
            Long id2 = teamDAO.save(team);
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
            assertEquals(3L, new TeamDAO().get(3L).getTeamNameId());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test get DAO *** ---> FINISH");
    }

    @Test
    @Order(3)
    void update() {

        log.info("*** Test update DAO *** ---> START");
        Team team = new Team();
        team.setId(3L);
        team.setEmployerId(4L);
        try {
            long id = new TeamDAO().update(team);
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