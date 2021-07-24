package edu.anderson.zaharov.service.impl;

import com.sun.xml.internal.ws.server.EndpointAwareTube;
import edu.anderson.zaharov.entity.FeedBack;
import edu.anderson.zaharov.repository.EntityDao;
import edu.anderson.zaharov.repository.impl.FeedBackDAO;
import edu.anderson.zaharov.service.EntityService;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class FeedBackDAOimpl implements EntityService<FeedBack> {

    private final EntityDao<FeedBack> dao = new FeedBackDAO();

    private long id;

    @Override
    public long save(FeedBack item) {

        try{
            id = dao.save(item);
        } catch (SQLException e) {
           log.error("save item error, {}", e.getMessage());
        }
        return id;
    }

    @Override
    public FeedBack get(long id) {
        return null;
    }

    @Override
    public void update(FeedBack item) {

    }

    @Override
    public void delete(long id) {

    }
}
