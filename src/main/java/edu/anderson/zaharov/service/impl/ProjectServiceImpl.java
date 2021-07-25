package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.Project;
import edu.anderson.zaharov.repository.EntityDao;
import edu.anderson.zaharov.repository.impl.ProjectDAO;
import edu.anderson.zaharov.service.EntityService;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class ProjectServiceImpl implements EntityService<Project> {

    private final EntityDao<Project> dao = new ProjectDAO();

    private long id;

    private Project feedBack;

    // service
    @Override
    public long save(Project item) {

        try {
            id = dao.save(item);
        } catch (SQLException e) {
            log.error("save item error, {}", e.getMessage());
        }
        return id;
    }


    @Override
    public Project get(long id) {
        try {
            feedBack = dao.get(id);
        } catch (SQLException e) {
            log.error(e.toString());
        }
        return feedBack;
    }


    @Override
    public void update(Project feedBack) {
        try {
            dao.update(feedBack);
        } catch (SQLException e) {
            log.error(e.toString());
        }
    }


    @Override
    public void delete(long id) {
        try {
            dao.delete(id);
        } catch (SQLException e) {
            log.error(e.toString());
        }
    }
}
