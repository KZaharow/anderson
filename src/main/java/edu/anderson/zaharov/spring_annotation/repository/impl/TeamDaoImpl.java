package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.entity.Team;
import edu.anderson.zaharov.spring_annotation.repository.TeamDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("teamDao")
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TeamDaoImpl implements TeamDao {

    private final SessionFactory sessionFactory;

    @Override
    public long saveOrUpdateEntityById(Team team) {

        sessionFactory.getCurrentSession().saveOrUpdate(team);
        Long id = team.getId();
        log.info(" ** --> Entity has been saved: {}", team);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public Team findEntityById(long id) {

        Team team = (Team) sessionFactory.getCurrentSession().
                getNamedQuery("Team.findById").
                setParameter("id", id).uniqueResult();
        log.info(" ** --> Entity has been found: {}", team);
        return team;
    }

    @Override
    public void deleteEntityByName(Team team) {

        sessionFactory.getCurrentSession().delete(team);
        log.info(" ** --> Entity has been deleted: {}", team);
    }
}
