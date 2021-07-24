package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.Project;
import edu.anderson.zaharov.exception.NoSuchDatabaseElementException;
import edu.anderson.zaharov.repository.EntityDao;

import java.sql.*;
import java.util.Date;
import java.util.Optional;

public class ProjectDAO implements EntityDao<Project> {

    private final PoolConnector poolConnector = PoolConnector.getInstance();

    /**
     * Save Project in database, return id
     */
    @Override
    public long save(Project project) throws SQLException {

        String query = "INSERT INTO project (name, costumer, finish_date, methodology, project_manager, team_name_id) VALUES (?,?,?,?,?,?)";
        long id = 0L;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getCostumer());
            preparedStatement.setTimestamp(3, new Timestamp(project.getFinishDate().getTime()));
            preparedStatement.setString(4, project.getMethodology());
            preparedStatement.setString(5, project.getProjectManager());
            preparedStatement.setLong(6, project.getTeamNameId());
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
     * Get project from database by id
     */
    @Override
    public Project get(long id) throws SQLException {

        String query = "SELECT (name, costumer, finish_date, methodology, project_manager, team_name_id) FROM project WHERE id = ?";
        Project project = null;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project = new Project();
                project.setId(id);
                project.setName(resultSet.getString("name"));
                project.setCostumer(resultSet.getString("costumer"));
                project.setFinishDate(new Date(resultSet.getTimestamp("finish_date").getTime()));
                project.setMethodology(resultSet.getString("methodology"));
                project.setProjectManager(resultSet.getString("project_manager"));
                project.setTeamNameId(resultSet.getLong("team_name_id"));
            }
        }
        return Optional.ofNullable(project).orElseThrow(NoSuchDatabaseElementException::new);
    }

    @Override
    public long update(Project project) throws SQLException {

        String query = "UPDATE project SET name=?, costumer=?, finish_date=?, methodology=?, project_manager=?, team_name_id=? WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getCostumer());
            preparedStatement.setTimestamp(3, new Timestamp(project.getFinishDate().getTime()));
            preparedStatement.setString(4, project.getMethodology());
            preparedStatement.setString(5, project.getProjectManager());
            preparedStatement.setLong(6, project.getTeamNameId());
            preparedStatement.setLong(7, project.getId());
        }
        return project.getId();
    }

    @Override
    public void delete(long id) throws SQLException {

        String query = "DELETE FROM project WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }
}
