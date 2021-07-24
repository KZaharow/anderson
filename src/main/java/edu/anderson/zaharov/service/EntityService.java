package edu.anderson.zaharov.service;

public interface EntityService<T> {
    long save(T item);

    T get(long id);

    void update(T item);

    void delete(long id);
}
