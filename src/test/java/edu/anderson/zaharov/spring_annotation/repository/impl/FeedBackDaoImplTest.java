package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.entity.FeedBack;
import edu.anderson.zaharov.spring_annotation.repository.FeedBackDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class FeedBackDaoImplTest {

    private static GenericApplicationContext ctx;

    private static FeedBackDao feedBackDao;

    @BeforeAll
    static void setUp() {

        ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        feedBackDao = ctx.getBean(FeedBackDao.class);
        assertNotNull(feedBackDao);
    }

    @Test
    public void testFindByID() {

        FeedBack feedBack = feedBackDao.findEntityById(1L);
        assertNotNull(feedBack);
        log.info(feedBack.toString());
    }

    @Test
    public void testInsert() {

        FeedBack feedBack = new FeedBack();
        feedBack.setText("test");
        feedBack.setDate(new Date());
        feedBackDao.saveOrUpdateEntityById(feedBack);
        assertNotNull(feedBack.getId());
        assertEquals("test", feedBackDao.findEntityById(feedBack.getId()).getText());
        log.info(feedBack.toString());
    }

    @Test
    public void testUpdate() {

        FeedBack feedBack = feedBackDao.findEntityById(1L);
        //making sure such feedBack exists
        assertNotNull(feedBack);
        //making sure we got expected record
        assertEquals("Замечательно справился", feedBack.getText());
        feedBack.setText("changed");
        feedBackDao.saveOrUpdateEntityById(feedBack);
        feedBack = feedBackDao.findEntityById(1L);
        assertEquals("changed", feedBack.getText());
        log.info(feedBack.toString());
    }

    @Test
    public void testDelete() {

        FeedBack feedBack = feedBackDao.findEntityById(1L);
        //making sure such feedBack exists
        assertNotNull(feedBack);
        feedBackDao.deleteEntityByName(feedBack);
        log.info(feedBack.toString());
    }


    @AfterAll
    static void tearDown() {

        ctx.close();
    }
}