package edu.anderson.zaharov.dao;


import edu.anderson.zaharov.entity.Project;

import java.util.List;

public interface ProjectDao {

    void deleteById(int id);

    Project findById(int id);

    List<Project> findAll();

    int insert(Project eproject);

    void update(Project eproject);
}
