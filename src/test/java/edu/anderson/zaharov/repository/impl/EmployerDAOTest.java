package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.Employer;
import edu.anderson.zaharov.enumeration.EnglishSkill;
import edu.anderson.zaharov.enumeration.WorkSkill;
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
class EmployerDAOTest {

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
        Employer employer = new Employer();
        employer.setName("test");
        employer.setSurName("test");
        employer.setPatronymic("test");
        employer.setEMail("test");
        employer.setTel("test");
        employer.setBirthday(new Date());
        employer.setExperience(0);
        employer.setEmploymentDate(new Date());
        employer.setProjectId(1);
        employer.setWorkSkill(WorkSkill.J1);
        employer.setEnglishSkill(EnglishSkill.A1);
        employer.setSkype("test");
        employer.setFeedbackId(1);
        EmployerDAO employerDAO = new EmployerDAO();
        try {
            Long id1 = employerDAO.save(employer);
            Long id2 = employerDAO.save(employer);
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
            assertEquals(3L, new EmployerDAO().get(3L).getId());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test get DAO *** ---> FINISH");
    }

    @Test
    @Order(3)
    void update() {

        log.info("*** Test update DAO *** ---> START");
        Employer employer = new Employer();
        employer.setId(3L);
        employer.setName("upd");
        employer.setSurName("upd");
        employer.setPatronymic("upd");
        employer.setEMail("upd");
        employer.setTel("upd");
        employer.setBirthday(new Date());
        employer.setExperience(0);
        employer.setEmploymentDate(new Date());
        employer.setProjectId(1);
        employer.setWorkSkill(WorkSkill.J1);
        employer.setEnglishSkill(EnglishSkill.A1);
        employer.setSkype("upd");
        employer.setFeedbackId(1);
        try {
            long id = new EmployerDAO().update(employer);
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
            new EmployerDAO().delete(5L);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("*** Test delete DAO *** ---> FINISH");
    }
}