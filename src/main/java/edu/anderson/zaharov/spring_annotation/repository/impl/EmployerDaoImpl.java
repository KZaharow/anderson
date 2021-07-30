package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.entity.Employer;
import edu.anderson.zaharov.spring_annotation.repository.EmployerDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("employerDao")
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EmployerDaoImpl implements EmployerDao {

    private final SessionFactory sessionFactory;

    @Override
    public long saveOrUpdateEntityById(Employer employer) {

        sessionFactory.getCurrentSession().saveOrUpdate(employer);
        Long id = employer.getId();
        log.info(" ** --> Entity has been saved: {}", employer);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public Employer findEntityById(long id) {

        Employer employer = (Employer) sessionFactory.getCurrentSession().
                getNamedQuery("Employer.findById").
                setParameter("id", id).uniqueResult();
        log.info(" ** --> Entity has been found: {}", employer);
        return employer;
    }

    @Override
    public void deleteEntityByName(Employer employer) {

        sessionFactory.getCurrentSession().delete(employer);
        log.info(" ** --> Entity has been deleted: {}", employer);
    }
}
