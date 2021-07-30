package edu.anderson.zaharov.dao;


import edu.anderson.zaharov.entity.Team;

import java.util.List;

public interface TeamDao {

    void deleteById(int id);

    Team findById(int id);

    List<Team> findAll();

    void insert(Team team);

    void update(Team team);
}
