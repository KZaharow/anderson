package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.entity.Project;
import edu.anderson.zaharov.spring_annotation.repository.ProjectDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ProjectDaoImplTest {

    private static GenericApplicationContext ctx;

    private static ProjectDao projectDao;

    @BeforeAll
    static void setUp() {

        ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        projectDao = ctx.getBean(ProjectDao.class);
        assertNotNull(projectDao);
    }

    @Test
    public void testFindByID() {

        Project project = projectDao.findEntityById(1L);
        assertNotNull(project);
        log.info(project.toString());
    }

    @Test
    public void testInsert() {

        Project project = new Project();
        project.setName("test");
        project.setCostumer("test");
        project.setFinishDate(new Date());
        project.setMethodology("test");
        project.setProjectManager("test");
        projectDao.saveOrUpdateEntityById(project);
        assertNotNull(project.getId());
        assertEquals("test", projectDao.findEntityById(project.getId()).getName());
        log.info(project.toString());
    }

    @Test
    public void testUpdate() {

        Project project = projectDao.findEntityById(1L);
        //making sure such project exists
        assertNotNull(project);
        //making sure we got expected record
        assertEquals("iPay", project.getName());
        project.setName("changed");
        projectDao.saveOrUpdateEntityById(project);
        project = projectDao.findEntityById(1L);
        assertEquals("changed", project.getName());
        log.info(project.toString());
    }

    @Test
    public void testDelete() {

        Project project = projectDao.findEntityById(1L);
        //making sure such project exists
        assertNotNull(project);
        projectDao.deleteEntityByName(project);
        log.info(project.toString());
    }


    @AfterAll
    static void tearDown() {

        ctx.close();
    }

}