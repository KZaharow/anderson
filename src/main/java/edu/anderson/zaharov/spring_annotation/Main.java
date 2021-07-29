package edu.anderson.zaharov.spring_annotation;

import edu.anderson.zaharov.spring_annotation.config.AppCfg;
import edu.anderson.zaharov.spring_annotation.yaml.YamlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String... args) {

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppCfg.class);
        int i = ctx.getBeanDefinitionCount();
        System.out.println(i);
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
