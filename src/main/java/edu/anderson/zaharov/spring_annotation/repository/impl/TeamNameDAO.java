package edu.anderson.zaharov.spring_annotation.repository.impl;


import edu.anderson.zaharov.spring_annotation.entity.TeamName;
import edu.anderson.zaharov.spring_annotation.repository.EntityDAO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional
@Repository("teamNameDAO")
public class TeamNameDAO implements EntityDAO<TeamName> {

    private SessionFactory sessionFactory;

    @Override
    public long save(TeamName teamName) throws SQLException {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public TeamName findById(long id) throws SQLException {

        return (TeamName) sessionFactory.getCurrentSession().
                getNamedQuery("team_name.findById").
                setParameter("id", id).uniqueResult();
    }

    @Override
    public long update(TeamName teamName) throws SQLException {
        return 0;
    }

    @Override
    public void delete(long id) throws SQLException {

    }
}
