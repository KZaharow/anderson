package edu.anderson.zaharov.repository.impl;

import edu.anderson.zaharov.connector.PoolConnector;
import edu.anderson.zaharov.entity.Employer;
import edu.anderson.zaharov.enumeration.EnglishSkill;
import edu.anderson.zaharov.enumeration.WorkSkill;
import edu.anderson.zaharov.exception.NoSuchDatabaseElementException;
import edu.anderson.zaharov.repository.EntityDao;

import java.sql.*;
import java.util.Date;
import java.util.Optional;

public class EmployerDAO implements EntityDao<Employer> {

    private final PoolConnector poolConnector = PoolConnector.getInstance();

    /**
     * Save Employer in database, return id
     */
    @Override
    public long save(Employer employer) throws SQLException {

        String query = "INSERT INTO employer (name, surname, patronymic, e_mail, tel, birthday," +
                " experience, employment_data, project_id, work_skill, english_skill, skype, feedback_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        long id = 0L;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employer.getName());
            preparedStatement.setString(2, employer.getSurName());
            preparedStatement.setString(3, employer.getPatronymic());
            preparedStatement.setString(4, employer.getEMail());
            preparedStatement.setString(5, employer.getTel());
            preparedStatement.setTimestamp(6, new Timestamp(employer.getBirthday().getTime()));
            preparedStatement.setInt(7, employer.getExperience());
            preparedStatement.setTimestamp(8, new Timestamp(employer.getEmploymentDate().getTime()));
            preparedStatement.setInt(9, employer.getProjectId());
            preparedStatement.setString(10, employer.getWorkSkill().name());
            preparedStatement.setString(11, employer.getEnglishSkill().name());
            preparedStatement.setString(12, employer.getSkype());
            preparedStatement.setInt(13, employer.getFeedbackId());
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
    public Employer get(long id) throws SQLException {

        String query = "SELECT name, surname, patronymic, e_mail, tel, birthday, experience, employment_data, project_id, " +
                "work_skill, english_skill, skype, feedback_id FROM employer WHERE id = ?";
        Employer employer = null;

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employer = new Employer();
                employer.setId(id);
                employer.setName(resultSet.getString("name"));
                employer.setSurName(resultSet.getString("surname"));
                employer.setPatronymic(resultSet.getString("patronymic"));
                employer.setEMail(resultSet.getString("e_mail"));
                employer.setTel(resultSet.getString("tel"));
                employer.setBirthday(new Date(resultSet.getTimestamp("birthday").getTime()));
                employer.setExperience(resultSet.getInt("experience"));
                employer.setEmploymentDate(new Date(resultSet.getTimestamp("employment_data").getTime()));
                employer.setProjectId(resultSet.getInt("project_id"));
                employer.setWorkSkill(WorkSkill.valueOf(resultSet.getString("work_skill")));
                employer.setEnglishSkill(EnglishSkill.valueOf(resultSet.getString("english_skill")));
                employer.setSkype(resultSet.getString("skype"));
                employer.setFeedbackId(resultSet.getInt("feedback_id"));
            }
        }
        return Optional.ofNullable(employer).orElseThrow(NoSuchDatabaseElementException::new);
    }

    @Override
    public long update(Employer employer) throws SQLException {

        String query = "UPDATE employer SET name=?, surname=?, patronymic=?, e_mail=?, tel=?, birthday=?, experience=?," +
                " employment_data=?, project_id=?, work_skill=?, english_skill=?, skype=?, feedback_id=? WHERE id = ?";

        try (Connection connection = poolConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employer.getName());
            preparedStatement.setString(2, employer.getSurName());
            preparedStatement.setString(3, employer.getPatronymic());
            preparedStatement.setString(4, employer.getEMail());
            preparedStatement.setString(5, employer.getTel());
            preparedStatement.setTimestamp(6, new Timestamp(employer.getBirthday().getTime()));
            preparedStatement.setInt(7, employer.getExperience());
            preparedStatement.setTimestamp(8, new Timestamp(employer.getEmploymentDate().getTime()));
            preparedStatement.setInt(9, employer.getProjectId());
            preparedStatement.setString(10, employer.getWorkSkill().name());
            preparedStatement.setString(11, employer.getEnglishSkill().name());
            preparedStatement.setString(12, employer.getSkype());
            preparedStatement.setInt(13, employer.getFeedbackId());
            preparedStatement.setLong(14, employer.getId());
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

