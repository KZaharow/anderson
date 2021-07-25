package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.Employer;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.EmployerDAO;
import edu.anderson.zaharov.service.EntityService;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class EmployerServiceImpl implements EntityService<Employer> {

    private final EntityDAO<Employer> dao = new EmployerDAO();

    private long id;

    private Employer employer;

    // service
    @Override
    public long save(Employer item) {

        try {
            id = dao.save(item);
        } catch (SQLException e) {
            log.error("save item error, {}", e.getMessage());
        }
        return id;
    }


    @Override
    public Employer get(long id) {
        try {
            employer = dao.get(id);
        } catch (SQLException e) {
            log.error(e.toString());
        }
        return employer;
    }


    @Override
    public void update(Employer feedBack) {
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
