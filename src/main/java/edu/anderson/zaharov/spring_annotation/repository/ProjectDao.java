package edu.anderson.zaharov.spring_annotation.repository;

import edu.anderson.zaharov.spring_annotation.entity.TeamName;

public interface ProjectDao {

    long saveOrUpdateEntityById(TeamName teamName);

    TeamName findEntityById(long id);

    void deleteEntityByName(TeamName teamName);
}
