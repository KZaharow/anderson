package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.AbstractDAO;
import edu.anderson.zaharov.dao.EmployerDao;
import edu.anderson.zaharov.entity.Employer;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class EmployerDaoImpl extends AbstractDAO implements EmployerDao {

    public void setSessionFactory(SessionFactory sessionFactory) {

        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void deleteById(long id) {


    }

    @Override
    public Employer findById(int id) {

        Criteria criteria = getSession().createCriteria(Employer.class);
        criteria.add(Restrictions.eq("id", id));
        return (Employer) criteria.uniqueResult();
    }

    @Override
    public List<Employer> findAll() {

        return (List<Employer>) getSession().createCriteria(Employer.class).list();
    }

    @Override
    public int insert(Employer employer) {

        getSession().save(employer);
        return employer.getId();
    }

    @Override
    public void update(Employer employer) {

        getSession().saveOrUpdate(employer);
    }
}
