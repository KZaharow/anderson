package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.Employer;
import edu.anderson.zaharov.entity.FeedBack;
import edu.anderson.zaharov.exception.NoSuchDatabaseElementException;
import edu.anderson.zaharov.repository.EntityDao;

import java.sql.*;
import java.util.Date;
import java.util.Optional;

package edu.anderson.zaharov.repository.impl;

public class EmployerDAO implements EntityDao<Employer> {

    private final PoolConnector poolConnector = PoolConnector.getInstance();

    /**
     * Save FeedBack in database, return id
     */
    @Override
    public long save(Employer employer) throws SQLException {

        String query = "INSERT INTO employer (name, surname, patronymic, e_mail, tel, birthday," +
                " experience, employment_data, project_id, work_skill, english_skill, skype, feedback_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        long id = 0L;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employer.);
            preparedStatement.setTimestamp(2, new Timestamp(employer.getDate().getTime()));
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
     * Get employer from database by id
     */
    @Override
    public FeedBack get(long id) throws SQLException {

        String query = "SELECT text, date FROM feedback WHERE id = ?";
        FeedBack employer = null;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employer = new FeedBack();
                employer.setId(id);
                employer.setText(resultSet.getString("text"));
                employer.setDate(new Date(resultSet.getTimestamp("date").getTime()));
            }
        }
        return Optional.ofNullable(employer).orElseThrow(NoSuchDatabaseElementException::new);
    }

    @Override
    public long update(FeedBack employer) throws SQLException {

        String query = "UPDATE employer SET text=?, date = ? WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employer.getText());
            preparedStatement.setTimestamp(2, new Timestamp(employer.getDate().getTime()));
            preparedStatement.setLong(3, employer.getId());
            preparedStatement.execute();
        }
        return employer.getId();
    }

    @Override
    public void delete(long id) throws SQLException {

        String query = "DELETE FROM employer WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }
}

