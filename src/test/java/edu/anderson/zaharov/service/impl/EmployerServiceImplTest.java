package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.Employer;
import edu.anderson.zaharov.enumeration.EnglishSkill;
import edu.anderson.zaharov.enumeration.WorkSkill;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.EmployerDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployerServiceImplTest {

    @Mock
    private final EntityDAO dao = mock(EmployerDAO.class);

    private Employer employer;

    @BeforeEach
    public void initializeEntities() {

        employer = new Employer();
        employer.setId(1L);
        employer.setName("test");
        employer.setSurName("test");
        employer.setPatronymic("test");
        employer.setEMail("test");
        employer.setTel("test");
        employer.setBirthday(new java.util.Date());
        employer.setExperience(0);
        employer.setEmploymentDate(new Date());
        employer.setProjectId(1);
        employer.setWorkSkill(WorkSkill.J1);
        employer.setEnglishSkill(EnglishSkill.A1);
        employer.setSkype("test");
        employer.setFeedbackId(1);
    }

    @AfterEach
    public void makeEntitiesNull() {

        employer = null;
    }

    @Test
    void save() throws SQLException {

        when(dao.save(employer)).thenReturn(employer.getId());
        assertEquals(employer.getId(), dao.save(employer));
    }

    @Test
    void get() throws SQLException {

        when(dao.get(employer.getId())).thenReturn(employer);
        assertEquals(employer, dao.get(employer.getId()));
    }

    @Test
    void update() throws SQLException {

        employer.setName("upd");
        dao.update(employer);
        when(dao.update(employer)).thenReturn(employer.getId());
        assertEquals(employer.getId(), dao.update(employer));
    }

    @Test
    void delete() throws SQLException {

        dao.delete(employer.getId());
        when(dao.get(employer.getId())).thenReturn(null);
        assertEquals(null, dao.get(employer.getId()));
    }
}