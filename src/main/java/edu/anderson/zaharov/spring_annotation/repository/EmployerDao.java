package edu.anderson.zaharov.spring_annotation.repository;

import edu.anderson.zaharov.spring_annotation.entity.Employer;

public interface EmployerDao {

    long saveOrUpdateEntityById(Employer employer);

    Employer findEntityById(long id);

    void deleteEntityByName(Employer employer);
}
