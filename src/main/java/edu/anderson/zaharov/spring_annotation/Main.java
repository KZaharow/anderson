package edu.anderson.zaharov.spring_annotation;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.repository.impl.TeamNameDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.SQLException;

public class Main {


    public static void main(String... args) {

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        TeamNameDAO teamNameDAO = ctx.getBean("teamNameDAO", TeamNameDAO.class);

        int i = ctx.getBeanDefinitionCount();
        System.out.println(i);

        try {
            System.out.println(teamNameDAO.findById(1L));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
        ctx.close();
/*
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        Singer singer = singerDao.findById(2l);
        logger.info(singer.toString());

        singerDao.delete(singer);

        listSingersWithAlbum(singerDao.findAllWithAlbum());
        ctx.close();*/
    }

    /*private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info(" ---- Listing singers with instruments:");
        singers.forEach(s -> {
            logger.info(s.toString());
            if (s.getAlbums() != null) {
                s.getAlbums().forEach(a -> logger.info("\t" + a.toString()));
            }
            if (s.getInstruments() != null) {
                s.getInstruments().forEach(i -> logger.info("\tInstrument: " + i.getInstrumentId()));
            }
        });
    }*/
}
