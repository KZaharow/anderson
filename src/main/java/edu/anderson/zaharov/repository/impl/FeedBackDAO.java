package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.FeedBack;
import edu.anderson.zaharov.exception.NoSuchDatabaseElementException;
import edu.anderson.zaharov.repository.EntityDAO;

import java.sql.*;
import java.util.Date;
import java.util.Optional;

public class FeedBackDAO implements EntityDAO<FeedBack> {

    private final PoolConnector poolConnector = PoolConnector.getInstance();

    /**
     * Save FeedBack in database, return id
     */
    @Override
    public long save(FeedBack feedBack) throws SQLException {

        String query = "INSERT INTO feedback (TEXT, DATE) VALUES (?,?)";
        long id = 0L;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, feedBack.getText());
            preparedStatement.setTimestamp(2, new Timestamp(feedBack.getDate().getTime()));
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
     * Get feedBack from database by id
     */
    @Override
    public FeedBack get(long id) throws SQLException {

        String query = "SELECT text, date FROM feedback WHERE id = ?";
        FeedBack feedBack = null;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                feedBack = new FeedBack();
                feedBack.setId(id);
                feedBack.setText(resultSet.getString("text"));
                feedBack.setDate(new Date(resultSet.getTimestamp("date").getTime()));
            }
        }
        return Optional.ofNullable(feedBack).orElseThrow(NoSuchDatabaseElementException::new);
    }

    @Override
    public long update(FeedBack feedBack) throws SQLException {

        String query = "UPDATE feedBack SET text=?, date = ? WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, feedBack.getText());
            preparedStatement.setTimestamp(2, new Timestamp(feedBack.getDate().getTime()));
            preparedStatement.setLong(3, feedBack.getId());
            preparedStatement.execute();
        }
        return feedBack.getId();
    }

    @Override
    public void delete(long id) throws SQLException {

        String query = "DELETE FROM feedBack WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }
}
