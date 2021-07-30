package edu.anderson.zaharov.spring_annotation.repository;

import edu.anderson.zaharov.spring_annotation.entity.Team;

public interface TeamDao {

    long saveOrUpdateEntityById(Team team);

    Team findEntityById(long id);

    void deleteEntityByName(Team team);
}
