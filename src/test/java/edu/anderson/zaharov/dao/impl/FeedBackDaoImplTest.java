package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.FeedBackDao;
import edu.anderson.zaharov.entity.FeedBack;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class FeedBackDaoImplTest {

    private static FeedBackDao feedBackDAO;

    @BeforeAll
    static void init() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
        feedBackDAO = (FeedBackDao) context.getBean("feedBackDAO");
    }

    @Test
    void setSessionFactory() {
    }

    @Test
    void deleteById() {

        int sizeBefore = feedBackDAO.findAll().size();
        feedBackDAO.deleteById(feedBackDAO.findAll().size());
        int sizeAfter = feedBackDAO.findAll().size();
        assertEquals(1, sizeBefore - sizeAfter);
    }

    @Test
    void findById() {

        FeedBack feedBack = feedBackDAO.findById(1);
        log.info(feedBack.toString());
        assertEquals(1, feedBack.getId());
    }

    @Test
    void findAll() {

        List<FeedBack> feedBacks = feedBackDAO.findAll();
        log.info(feedBacks.toString());
        assertNotNull(feedBacks.size());
    }

    @Test
    void insert() {

        FeedBack feedBack = new FeedBack();
        feedBack.setText("test");
        feedBack.setDate(new Date());
        int id = feedBackDAO.insert(feedBack);
        log.info("id=" + id);
        log.info(feedBack.toString());
        assertEquals(id, feedBackDAO.findById(id).getId());
    }

    @Test
    void update() {

        FeedBack feedBack = feedBackDAO.findById(1);
        log.info(feedBack.toString());
        feedBack.setText("ops");
        feedBackDAO.update(feedBack);
        assertEquals("ops", feedBackDAO.findById(1).getText());
    }

}