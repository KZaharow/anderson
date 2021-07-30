package edu.anderson.zaharov.dao;


import edu.anderson.zaharov.entity.Company;
import edu.anderson.zaharov.entity.Employer;

import java.util.List;

public interface EmployerDao {

    void deleteById(long id);

    Employer findById(String name);

    List<Employer> findAll();

    void insert(Employer employer);

    void update(Employer employer);
}
