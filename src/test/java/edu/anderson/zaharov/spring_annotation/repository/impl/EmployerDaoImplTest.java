package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.entity.Employer;
import edu.anderson.zaharov.spring_annotation.entity.FeedBack;
import edu.anderson.zaharov.spring_annotation.entity.Project;
import edu.anderson.zaharov.spring_annotation.enumeration.EnglishSkill;
import edu.anderson.zaharov.spring_annotation.enumeration.WorkSkill;
import edu.anderson.zaharov.spring_annotation.repository.EmployerDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EmployerDaoImplTest {

    private static GenericApplicationContext ctx;

    private static EmployerDao employerDao;

    @BeforeAll
    static void setUp() {

        ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        employerDao = ctx.getBean(EmployerDao.class);
        assertNotNull(employerDao);
    }

    @Test
    public void testFindByID() {

        Employer employer = employerDao.findEntityById(1L);
        assertNotNull(employer);
        log.info(employer.toString());
    }

    @Test
    public void testInsert() {

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
        employerDao.saveOrUpdateEntityById(employer);
        assertNotNull(employer.getId());
        assertEquals("test", employerDao.findEntityById(employer.getId()).getName());
        log.info(employer.toString());
    }

    @Test
    public void testUpdate() {

        Employer employer = employerDao.findEntityById(1L);
        //making sure such employer exists
        assertNotNull(employer);
        //making sure we got expected record
        assertEquals("Test", employer.getName());
        employer.setName("changed");
        employerDao.saveOrUpdateEntityById(employer);
        employer = employerDao.findEntityById(1L);
        assertEquals("changed", employer.getName());
        log.info(employer.toString());
    }

    @Test
    public void testDelete() {

        Employer employer = employerDao.findEntityById(1L);
        //making sure such employer exists
        assertNotNull(employer);
        employerDao.deleteEntityByName(employer);
        log.info(employer.toString());
    }


    @AfterAll
    static void tearDown() {

        ctx.close();
    }
}