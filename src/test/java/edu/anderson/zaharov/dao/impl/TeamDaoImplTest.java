package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.TeamDao;
import edu.anderson.zaharov.entity.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class TeamDaoImplTest {

    private static TeamDao teamDAO;

    @BeforeAll
    static void init() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
        teamDAO = (TeamDao) context.getBean("teamDAO");
    }

    @Test
    void deleteById() {

        List<Team> team = teamDAO.findAll();
        int sizeBefore = team.size();
        teamDAO.deleteById(team.get(team.size() - 1).getId());
        int sizeAfter = teamDAO.findAll().size();
        assertEquals(1, sizeBefore - sizeAfter);
    }

    @Test
    void findById() {

        Team team = teamDAO.findById(1);
        log.info(team.toString());
        assertEquals(1, team.getId());
    }

    @Test
    void findAll() {

        List<Team> team = teamDAO.findAll();
        log.info(team.toString());
        assertTrue(team.size() > 0);
    }

    @Test
    void insert() {

        Team team = new Team();
        team.setName("test");
        int id = teamDAO.insert(team);
        log.info("id=" + id);
        log.info(team.toString());
        assertEquals(id, teamDAO.findById(id).getId());
    }

    @Test
    void update() {

        Team team = teamDAO.findById(1);
        log.info(team.toString());
        team.setName("ops");
        teamDAO.update(team);
        assertEquals("ops", teamDAO.findById(1).getName());
    }
}