package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.entity.Employer;
import edu.anderson.zaharov.spring_annotation.entity.FeedBack;
import edu.anderson.zaharov.spring_annotation.entity.Project;
import edu.anderson.zaharov.spring_annotation.entity.Team;
import edu.anderson.zaharov.spring_annotation.enumeration.EnglishSkill;
import edu.anderson.zaharov.spring_annotation.enumeration.WorkSkill;
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

        FeedBack feedBack = new FeedBack();
        feedBack.setText("feedBack");
        feedBack.setDate(new Date());

        Project project = new Project();
        project.setName("project");
        project.setCostumer("costumer");
        project.setFinishDate(new Date());
        project.setMethodology("spring");
        project.setProjectManager("doctor");

        Employer employer = new Employer();
        employer.setName("test");
        employer.setSurName("test");
        employer.setPatronymic("test");
        employer.setEMail("test");
        employer.setTel("test");
        employer.setBirthday(new java.util.Date());
        employer.setExperience(0);
        employer.setEmploymentDate(new Date());
        employer.setWorkSkill(WorkSkill.J1);
        employer.setEnglishSkill(EnglishSkill.A1);
        employer.setSkype("test");
        employer.setFeedBack(feedBack);
        employer.setProject(project);

        team.setName("team test");
        team.addEmployer(employer);

        teamDao.saveOrUpdateEntityById(team);
        assertNotNull(team.getId());
        assertEquals("test team", teamDao.findEntityById(team.getId()).getName());
        log.info(team.toString());
    }

    @Test
    public void testUpdate() {

        Team team = teamDao.findEntityById(1L);
        //making sure such feam exists
        assertNotNull(team);
        //making sure we got expected record
        assertEquals("Команда А", team.getName());
        team.setName("upd");
        teamDao.saveOrUpdateEntityById(team);
        team = teamDao.findEntityById(1L);
        assertEquals("upd", team.getName());
        log.info(team.toString());
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