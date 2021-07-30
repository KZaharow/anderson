package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.ProjectDao;
import edu.anderson.zaharov.entity.Project;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class ProjectDaoImplTest {

    private static ProjectDao projectDAO;

    @BeforeAll
    static void init() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
        projectDAO = (ProjectDao) context.getBean("projectDAO");
    }

    @Test
    void deleteById() {

        List<Project> projects = projectDAO.findAll();
        int sizeBefore = projects.size();
        projectDAO.deleteById(projects.get(projects.size() - 1).getId());
        int sizeAfter = projectDAO.findAll().size();
        assertEquals(1, sizeBefore - sizeAfter);
    }

    @Test
    void findById() {

        Project project = projectDAO.findById(1);
        log.info(project.toString());
        assertEquals(1, project.getId());
    }

    @Test
    void findAll() {

        List<Project> projects = projectDAO.findAll();
        log.info(projects.toString());
        assertTrue(projects.size() > 0);
    }

    @Test
    void insert() {

        Project project = new Project();
        project.setName("test");
        project.setCostumer("test");
        project.setFinishDate(new Date());
        project.setMethodology("test");
        project.setProjectManager("test");
        int id = projectDAO.insert(project);
        log.info("id=" + id);
        log.info(project.toString());
        assertEquals(id, projectDAO.findById(id).getId());
    }

    @Test
    void update() {

        Project project = projectDAO.findById(1);
        log.info(project.toString());
        project.setName("ops");
        projectDAO.update(project);
        assertEquals("ops", projectDAO.findById(1).getName());
    }
}