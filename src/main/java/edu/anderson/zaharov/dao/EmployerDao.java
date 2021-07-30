package edu.anderson.zaharov.dao;


import edu.anderson.zaharov.entity.Employer;

import java.util.List;

public interface EmployerDao {

    void deleteById(int id);

    Employer findById(int id);

    List<Employer> findAll();

    int insert(Employer employer);

    void update(Employer employer);
}
