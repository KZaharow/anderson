package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.AbstractDAO;
import edu.anderson.zaharov.dao.EmployerDao;
import edu.anderson.zaharov.entity.Company;
import edu.anderson.zaharov.entity.Employer;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployerDaoImpl extends AbstractDAO implements EmployerDao {

    public void setSessionFactory(SessionFactory sessionFactory) {

        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Employer findById(String name) {
        return null;
    }

    @Override
    public List<Employer> findAll() {

        return (List<Employer>) getSession().createCriteria(Company.class).list();
    }

    @Override
    public void insert(Employer employer) {

    }

    @Override
    public void update(Employer employer) {

    }
}
