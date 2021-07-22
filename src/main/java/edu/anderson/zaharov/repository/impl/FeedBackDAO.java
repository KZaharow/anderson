package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.FeedBack;
import edu.anderson.zaharov.repository.EntityDao;

import java.sql.*;
import java.util.Optional;

public class FeedBackDAO implements EntityDao<FeedBack> {

    private final PoolConnector poolConnector = PoolConnector.getInstance();

    /**
     * Save FeedBack in database, return id
     */
    @Override
    public long save(FeedBack feedBack) throws SQLException {

        String query = "INSERT INTO FEEDBACK (TEXT, DATE) VALUES (?,?)";
        long id = 0L;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, feedBack.getText());
            preparedStatement.setDate(2, new Date(feedBack.getDate().getTime()));
            preparedStatement.execute();

            // find id
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        }
        return id;
    }/*

    @Override
    public long save(FeedBack feedBack) throws SQLException {
        return 0;
    }

    */

    @Override
    public FeedBack get(long id) throws SQLException {
        return null;
    }

    @Override
    public long update(FeedBack feedBack) throws SQLException {
        return 0;
    }

    @Override
    public void delete(long id) throws SQLException {

    } /**
     * Get genre from database by id
     *//*
    @Override
    public Genre get(long id) throws SQLException {
        String query = "SELECT genre_name FROM genre WHERE id = ?";
        Genre genre = null;

        try (Connection connection = poolConnector.getDataSource()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                genre = new Genre();
                genre.setId(id);
                genre.setName(resultSet.getString("genre_name"));
            }
        }
        return Optional.ofNullable(genre).orElseThrow(NoSuchDatabaseElementException::new);
    }

    @Override
    public long update(FeedBack feedBack) throws SQLException {
        return 0;
    }

    *//**
     * Update genre in database
     *//*
    @Override
    public long update(Genre genre) throws SQLException {
        String query = "UPDATE genre SET genre_name = ? WHERE id = ?";

        try (Connection connection = poolConnector.getDataSource()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setLong(2, genre.getId());
            preparedStatement.execute();
        }
        return genre.getId();
    }

    *//**
     * Delete genre in database by id
     *//*
    @Override
    public void delete(long id) throws SQLException {
        String query = "DELETE FROM genre WHERE id = ?";

        try (Connection connection = poolConnector.getDataSource()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }*/
}
