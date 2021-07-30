package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.AbstractDAO;
import edu.anderson.zaharov.dao.TeamDao;
import edu.anderson.zaharov.entity.Employer;
import edu.anderson.zaharov.entity.Team;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TeamDaoImpl extends AbstractDAO implements TeamDao {

    public void setSessionFactory(SessionFactory sessionFactory) {

        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Team findById(int id) {

        Criteria criteria = getSession().createCriteria(Team.class);
        criteria.add(Restrictions.eq("id", id));
        return (Team) criteria.uniqueResult();
    }

    @Override
    public List<Team> findAll() {

        return (List<Team>) getSession().createCriteria(Team.class).list();
    }

    @Override
    public void insert(Team employer) {

    }

    @Override
    public void update(Team employer) {

    }
}
