package edu.anderson.zaharov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDAO {

    private SessionFactory sessionFactory;

    protected Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    protected void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory; }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}