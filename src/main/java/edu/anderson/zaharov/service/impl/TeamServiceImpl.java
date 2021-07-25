package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.Team;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.TeamDAO;
import edu.anderson.zaharov.service.EntityService;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class TeamServiceImpl implements EntityService<Team> {

    private final EntityDAO<Team> dao = new TeamDAO();

    private long id;

    private Team team;

    // service
    @Override
    public long save(Team item) {

        try {
            id = dao.save(item);
        } catch (SQLException e) {
            log.error("save item error, {}", e.getMessage());
        }
        return id;
    }


    @Override
    public Team get(long id) {
        try {
            team = dao.get(id);
        } catch (SQLException e) {
            log.error(e.toString());
        }
        return team;
    }


    @Override
    public void update(Team feedBack) {
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
