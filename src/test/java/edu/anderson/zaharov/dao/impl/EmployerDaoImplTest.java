package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.EmployerDao;
import edu.anderson.zaharov.entity.Employer;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j
class EmployerDaoImplTest {

    private static EmployerDao employerDao;

    @BeforeAll
    static void init() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
        employerDao = (EmployerDao) context.getBean("employerDAO");
    }

    @Test
    void setSessionFactory() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {

        List<Employer> employers = employerDao.findAll();
        log.
        assertEquals(2, employers.size());
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }
}