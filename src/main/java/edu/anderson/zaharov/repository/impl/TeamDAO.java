package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.Project;
import edu.anderson.zaharov.exception.NoSuchDatabaseElementException;
import edu.anderson.zaharov.repository.EntityDao;

import java.sql.*;
import java.util.Optional;

public class TeamDAO implements EntityDao<Project> {

    private final PoolConnector poolConnector = PoolConnector.getInstance();

    /**
     * Save Team in database, return id
     */
    @Override
    public long save(Project team) throws SQLException {

        String query = "INSERT INTO team (team_name_id, employer_id) VALUES (?,?)";
        long id = 0L;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, team.getTeamNameId());
            preparedStatement.setLong(2, team.getEmployerId());
            preparedStatement.execute();

            // find id
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        }
        return id;
    }

    /**
     * Get team from database by id
     */
    @Override
    public Project get(long id) throws SQLException {

        String query = "SELECT (team_name_id, employer_id) FROM team WHERE id = ?";
        Project team = null;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                team = new Project();
                team.setId(id);
                team.setTeamNameId(resultSet.getLong("team_name_id"));
                team.setEmployerId(resultSet.getLong("employer_id"));
            }
        }
        return Optional.ofNullable(team).orElseThrow(NoSuchDatabaseElementException::new);
    }

    @Override
    public long update(Project team) throws SQLException {

        String query = "UPDATE team SET team_name_id=?, employer_id = ? WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, team.getTeamNameId());
            preparedStatement.setLong(2, team.getEmployerId());
            preparedStatement.setLong(3, team.getId());
            preparedStatement.execute();
        }
        return team.getId();
    }

    @Override
    public void delete(long id) throws SQLException {

        String query = "DELETE FROM team WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }
}
