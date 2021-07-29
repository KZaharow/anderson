package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.entity.TeamName;
import edu.anderson.zaharov.spring_annotation.repository.TeamNameDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class TeamNameDaoImplTest {

    private GenericApplicationContext ctx;

    private TeamNameDao teamNameDao;

    @BeforeAll
    public static void setUp() {

        ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        teamNameDao = ctx.getBean(TeamNameDao.class);
        assertNotNull(teamNameDao);
    }

    @Test
    public void testFindByID() {

        TeamName teamName = teamNameDao.findEntityById(1L);
        assertNotNull(teamName);
        log.info(teamName.toString());
    }

    @Test
    public void testInsert() {

        TeamName teamName = new TeamName();
        teamName.setName("test");
        teamNameDao.saveOrUpdateEntityById(teamName);
        assertNotNull(teamName.getId());
        log.info(teamName.toString());
    }

    @Test
    public void testUpdate() {

        TeamName teamName = teamNameDao.findEntityById(3L);
        //making sure such teamName exists
        assertNotNull(teamName);
        //making sure we got expected record
        assertEquals("test", teamName.getName());
        teamName.setName("changed");
        teamNameDao.saveOrUpdateEntityById(teamName);
        teamName = teamNameDao.findEntityById(3L);
        assertEquals("changed", teamName.getName());
    }

    @Test
    public void testDelete() {

        TeamName teamName = teamNameDao.findEntityById(3l);
        //making sure such teamName exists
        assertNotNull(teamName);
        teamNameDao.deleteEntityByName(teamName);
    }


    @AfterAll
    public void tearDown() {

        ctx.close();
    }
}