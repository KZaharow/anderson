package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.TeamName;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.TeamNameDAO;
import edu.anderson.zaharov.service.EntityService;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class TeamNameServiceImpl implements EntityService<TeamName> {

    private final EntityDAO<TeamName> dao = new TeamNameDAO();

    private long id;

    private TeamName teamName;

    // service
    @Override
    public long save(TeamName item) {

        try {
            id = dao.save(item);
        } catch (SQLException e) {
            log.error("save item error, {}", e.getMessage());
        }
        return id;
    }


    @Override
    public TeamName get(long id) {
        try {
            teamName = dao.get(id);
        } catch (SQLException e) {
            log.error(e.toString());
        }
        return teamName;
    }


    @Override
    public void update(TeamName feedBack) {
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
