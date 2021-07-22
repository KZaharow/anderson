package edu.anderson.zaharov.repository;

import java.sql.SQLException;

public interface EntityDao<T> {

    long save(T t)throws SQLException;

    T get(long id) throws SQLException;

    long update(T t) throws SQLException;

    void delete(long id) throws SQLException;
}