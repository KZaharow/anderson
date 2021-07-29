package edu.anderson.zaharov.spring_annotation.repository;

import java.sql.SQLException;

public interface EntityDAO<T> {

    long save(T t)throws SQLException;

    T findById(long id) throws SQLException;

    long update(T t) throws SQLException;

    void delete(long id) throws SQLException;
}