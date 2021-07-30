package edu.anderson.zaharov.dao;


import edu.anderson.zaharov.entity.FeedBack;

import java.util.List;

public interface FeedBackDao {

    void deleteById(int id);

    FeedBack findById(int id);

    List<FeedBack> findAll();

    int insert(FeedBack feedBack);

    void update(FeedBack feedBack);
}
