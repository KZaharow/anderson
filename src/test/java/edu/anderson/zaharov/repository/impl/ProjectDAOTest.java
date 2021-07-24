package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.Project;
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
class ProjectDAOTest {

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
        Project project = new Project();
        project.setName("test");
        project.setCostumer("test");
        project.setFinishDate(new Date());
        project.setMethodology("test");
        project.setProjectManager("test");
        project.setTeamNameId(1L);
        ProjectDAO projectDAO = new ProjectDAO();
        try {
            Long id1 = projectDAO.save(project);
            Long id2 = projectDAO.save(project);
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
            assertEquals(3L, new ProjectDAO().get(3L).getId());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test get DAO *** ---> FINISH");
    }

    @Test
    @Order(3)
    void update() {

        log.info("*** Test update DAO *** ---> START");
        Project project = new Project();
        project.setId(3L);
        project.setName("upd");
        project.setCostumer("upd");
        project.setFinishDate(new Date());
        project.setMethodology("upd");
        project.setProjectManager("upd");
        try {
            long id = new ProjectDAO().update(project);
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
            new ProjectDAO().delete(5L);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test delete DAO *** ---> FINISH");
    }
}