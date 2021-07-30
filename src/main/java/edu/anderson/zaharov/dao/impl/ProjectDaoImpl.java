package edu.anderson.zaharov.dao.impl;

import edu.anderson.zaharov.dao.AbstractDAO;
import edu.anderson.zaharov.dao.ProjectDao;
import edu.anderson.zaharov.entity.Project;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ProjectDaoImpl  extends AbstractDAO implements ProjectDao {
    
    public void setSessionFactory(SessionFactory sessionFactory) {

        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void deleteById(int id) {

        getSession().delete(findById(id));
    }

    @Override
    public Project findById(int id) {

        Criteria criteria = getSession().createCriteria(Project.class);
        criteria.add(Restrictions.eq("id", id));
        return (Project) criteria.uniqueResult();
    }

    @Override
    public List<Project> findAll() {

        return (List<Project>) getSession().createCriteria(Project.class).list();
    }

    @Override
    public int insert(Project project) {

        getSession().save(project);
        return project.getId();
    }

    @Override
    public void update(Project project) {

        getSession().saveOrUpdate(project);
    }
}
