package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.TeamName;
import edu.anderson.zaharov.exception.NoSuchDatabaseElementException;
import edu.anderson.zaharov.repository.EntityDao;

import java.sql.*;
import java.util.Optional;

public class TeamNameDAO implements EntityDao<TeamName> {

    private final PoolConnector poolConnector = PoolConnector.getInstance();

    /**
     * Save TeamName in database, return id
     */
    @Override
    public long save(TeamName teamName) throws SQLException {

        String query = "INSERT INTO team_name (name) VALUES (?)";
        long id = 0L;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, teamName.getName());
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
     * Get teamName from database by id
     */
    @Override
    public TeamName get(long id) throws SQLException {

        String query = "SELECT name FROM team_name WHERE id = ?";
        TeamName teamName = null;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teamName = new TeamName();
                teamName.setId(id);
                teamName.setName(resultSet.getString("name"));
            }
        }
        return Optional.ofNullable(teamName).orElseThrow(NoSuchDatabaseElementException::new);
    }

    @Override
    public long update(TeamName teamName) throws SQLException {

        String query = "UPDATE team_name SET name = ? WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, teamName.getName());
            preparedStatement.setLong(2, teamName.getId());
            preparedStatement.execute();
        }
        return teamName.getId();
    }

    @Override
    public void delete(long id) throws SQLException {

        String query = "DELETE FROM team_name WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }
}
