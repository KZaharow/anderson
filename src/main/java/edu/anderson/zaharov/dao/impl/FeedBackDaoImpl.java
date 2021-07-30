package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.AbstractDAO;
import edu.anderson.zaharov.dao.FeedBackDao;
import edu.anderson.zaharov.entity.FeedBack;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class FeedBackDaoImpl extends AbstractDAO implements FeedBackDao {
    
    public void setSessionFactory(SessionFactory sessionFactory) {

        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void deleteById(int id) {

        getSession().delete(findById(id));
    }

    @Override
    public FeedBack findById(int id) {

        Criteria criteria = getSession().createCriteria(FeedBack.class);
        criteria.add(Restrictions.eq("id", id));
        return (FeedBack) criteria.uniqueResult();
    }

    @Override
    public List<FeedBack> findAll() {

        return (List<FeedBack>) getSession().createCriteria(FeedBack.class).list();
    }

    @Override
    public int insert(FeedBack feedBack) {

        getSession().save(feedBack);
        return feedBack.getId();
    }

    @Override
    public void update(FeedBack feedBack) {

        getSession().saveOrUpdate(feedBack);
    }
}
