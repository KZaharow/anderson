package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.EmployerDao;
import edu.anderson.zaharov.entity.Employer;
import edu.anderson.zaharov.enumeration.EnglishSkill;
import edu.anderson.zaharov.enumeration.WorkSkill;
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
class EmployerDaoImplTest {

    private static EmployerDao employerDao;

    @BeforeAll
    static void init() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
        employerDao = (EmployerDao) context.getBean("employerDAO");
    }

    @Test
    void deleteById() {

        List<Employer> employers = employerDao.findAll();
        int sizeBefore = employers.size();
        employerDao.deleteById(employers.get(employers.size() - 1).getId());
        int sizeAfter = employerDao.findAll().size();
        assertEquals(1, sizeBefore - sizeAfter);
    }

    @Test
    void findById() {

        Employer employer = employerDao.findById(1);
        log.info(employer.toString());
        assertEquals(1, employer.getId());
    }

    @Test
    void findAll() {

        List<Employer> employers = employerDao.findAll();
        log.info(employers.toString());
        assertTrue(employers.size() > 0);
    }

    @Test
    void insert() {

        Employer employer = new Employer();
        employer.setName("test");
        employer.setSurName("test");
        employer.setPatronymic("test");
        employer.setMail("test");
        employer.setTel("test");
        employer.setBirthday(new Date());
        employer.setExperience(0);
        employer.setEmploymentDate(new Date());
        employer.setProjectId(1);
        employer.setWorkSkill(WorkSkill.J1.name());
        employer.setEnglishSkill(EnglishSkill.A1.name());
        employer.setSkype("test");
        employer.setProjectId(1);
        employer.setTeamId(1);
        employer.setFeedbackId(1);
        int id = employerDao.insert(employer);
        log.info("id=" + id);
        log.info(employer.toString());
        assertEquals(id, employerDao.findById(id).getId());
    }

    @Test
    void update() {

        Employer employer = employerDao.findById(1);
        log.info(employer.toString());
        employer.setProjectId(5);
        employerDao.update(employer);
        assertEquals(5, employerDao.findById(1).getProjectId());
    }
}