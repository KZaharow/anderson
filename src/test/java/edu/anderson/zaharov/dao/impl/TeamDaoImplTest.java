package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.TeamDao;
import edu.anderson.zaharov.dao.TeamDao;
import edu.anderson.zaharov.entity.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TeamDaoImplTest {

    private static TeamDao teamDao;

    @BeforeAll
    static void init() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
        teamDao = (TeamDao) context.getBean("teamDAO");
    }

    @Test
    void setSessionFactory() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {

        Team team = teamDao.findById(1);
        log.info(team.toString());
        assertEquals(1, team.getId());
    }

    @Test
    void findAll() {

        List<Team> teams = teamDao.findAll();
        log.info(teams.toString());
        assertEquals(2, teams.size());
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

}