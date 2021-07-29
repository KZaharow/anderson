package edu.anderson.zaharov.spring_annotation;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.entity.TeamName;
import edu.anderson.zaharov.spring_annotation.repository.TeamNameDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {


    public static void main(String... args) {

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        TeamNameDao teamNameDao = ctx.getBean(TeamNameDao.class);

        teamNameDao.findEntityById(1L);
        TeamName teamName = new TeamName();
        teamName.setName("test");
        long l = teamNameDao.SaveOrUpdateEntityById(teamName);
        teamName.setId(l);
        teamName.setName("test change");
        l = teamNameDao.SaveOrUpdateEntityById(teamName);
        teamNameDao.findEntityById(l);
        teamNameDao.deleteEntityById(teamName);
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
