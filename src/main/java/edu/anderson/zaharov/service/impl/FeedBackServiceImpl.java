package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.FeedBack;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.FeedBackDAO;
import edu.anderson.zaharov.service.EntityService;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class FeedBackServiceImpl implements EntityService<FeedBack> {

    private final EntityDAO<FeedBack> dao = new FeedBackDAO();

    private long id;

    private FeedBack feedBack;

    // service
    @Override
    public long save(FeedBack item) {

        try {
            id = dao.save(item);
        } catch (SQLException e) {
            log.error("save item error, {}", e.getMessage());
        }
        return id;
    }


    @Override
    public FeedBack get(long id) {
        try {
            feedBack = dao.get(id);
        } catch (SQLException e) {
            log.error(e.toString());
        }
        return feedBack;
    }


    @Override
    public void update(FeedBack feedBack) {
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
