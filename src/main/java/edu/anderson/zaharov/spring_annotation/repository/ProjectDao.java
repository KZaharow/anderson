package edu.anderson.zaharov.spring_annotation.repository;

import edu.anderson.zaharov.spring_annotation.entity.Project;

public interface ProjectDao {

    long saveOrUpdateEntityById(Project project);

    Project findEntityById(long id);

    void deleteEntityByName(Project project);
}
