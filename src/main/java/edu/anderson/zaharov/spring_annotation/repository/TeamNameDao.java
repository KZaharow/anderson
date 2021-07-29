package edu.anderson.zaharov.spring_annotation.repository;

import edu.anderson.zaharov.spring_annotation.entity.TeamName;

public interface TeamNameDao {

    long SaveOrUpdateEntityById(TeamName teamName);

    TeamName findEntityById(long id);

    void deleteEntityById(TeamName teamName);
}