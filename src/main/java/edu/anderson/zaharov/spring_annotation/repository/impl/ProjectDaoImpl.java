package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.entity.Project;
import edu.anderson.zaharov.spring_annotation.repository.ProjectDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("projectDao")
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    private final SessionFactory sessionFactory;

    @Override
    public long saveOrUpdateEntityById(Project project) {

        sessionFactory.getCurrentSession().saveOrUpdate(project);
        Long id = project.getId();
        log.info(" ** --> Entity has been saved: {}", project);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public Project findEntityById(long id) {

        Project project = (Project) sessionFactory.getCurrentSession().
                getNamedQuery("Project.findById").
                setParameter("id", id).uniqueResult();
        log.info(" ** --> Entity has been found: {}", project);
        return project;
    }

    @Override
    public void deleteEntityByName(Project project) {

        sessionFactory.getCurrentSession().delete(project);
        log.info(" ** --> Entity has been deleted: {}", project);
    }
}
