package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.entity.Employer;
import edu.anderson.zaharov.spring_annotation.entity.Team;
import edu.anderson.zaharov.spring_annotation.repository.TeamDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TeamDaoImplTest {

    private static GenericApplicationContext ctx;

    private static TeamDao teamDao;

    @BeforeAll
    static void setUp() {

        ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        teamDao = ctx.getBean(TeamDao.class);
        assertNotNull(teamDao);
    }

    @Test
    public void testFindByID() {

        Team feam = teamDao.findEntityById(1L);
        assertNotNull(feam);
        log.info(feam.toString());
    }

    @Test
    public void testInsert() {

        Team team = new Team();

        Employer employer= new Employer();
        empl

        team.set
        team.set("test");
        team.setDate(new Date());
        teamDao.saveOrUpdateEntityById(team);
        assertNotNull(team.getId());
        assertEquals("test", teamDao.findEntityById(team.getId()).getText());
        log.info(team.toString());
    }

    @Test
    public void testUpdate() {

        Team feam = teamDao.findEntityById(1L);
        //making sure such feam exists
        assertNotNull(feam);
        //making sure we got expected record
        assertEquals("Замечательно справился", feam.getText());
        feam.setText("changed");
        teamDao.saveOrUpdateEntityById(feam);
        feam = teamDao.findEntityById(1L);
        assertEquals("changed", feam.getText());
        log.info(feam.toString());
    }

    @Test
    public void testDelete() {

        Team feam = teamDao.findEntityById(1L);
        //making sure such feam exists
        assertNotNull(feam);
        teamDao.deleteEntityByName(feam);
        log.info(feam.toString());
    }


    @AfterAll
    static void tearDown() {

        ctx.close();
    }
}