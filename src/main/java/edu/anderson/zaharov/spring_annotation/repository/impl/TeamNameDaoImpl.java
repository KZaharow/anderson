package edu.anderson.zaharov.spring_annotation.repository.impl;


import edu.anderson.zaharov.spring_annotation.entity.TeamName;
import edu.anderson.zaharov.spring_annotation.repository.TeamNameDao;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("teamNameDAO")
@Slf4j
public class TeamNameDaoImpl implements TeamNameDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long saveOrUpdateEntityById(TeamName teamName) {

        sessionFactory.getCurrentSession().saveOrUpdate(teamName);
        Long id = teamName.getId();
        log.info(" ** --> Entity has been saved: {}", teamName);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public TeamName findEntityById(long id) {

        TeamName teamName = (TeamName) sessionFactory.getCurrentSession().
                getNamedQuery("TeamName.findById").
                setParameter("id", id).uniqueResult();
        log.info(" ** --> Entity has been found: {}", teamName);
        return teamName;
    }

    @Override
    public void deleteEntityByName(TeamName teamName) {

        sessionFactory.getCurrentSession().delete(teamName);
        log.info(" ** --> Entity has been deleted: {}", teamName);
    }
}
