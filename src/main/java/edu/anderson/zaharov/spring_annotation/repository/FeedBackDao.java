package edu.anderson.zaharov.spring_annotation.repository;

import edu.anderson.zaharov.spring_annotation.entity.FeedBack;

public interface FeedBackDao {

    long saveOrUpdateEntityById(FeedBack feedBack);

    FeedBack findEntityById(long id);

    void deleteEntityByName(FeedBack feedBack);
}
