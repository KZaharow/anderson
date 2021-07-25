package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.TeamName;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.TeamNameDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TeamNameServiceImplTest {

    @Mock
    private final EntityDAO dao = mock(TeamNameDAO.class);

    private TeamName teamName;

    @BeforeEach
    public void initializeEntities() {

        teamName = new TeamName();
        teamName.setId(1L);
        teamName.setName("test");
    }

    @AfterEach
    public void makeEntitiesNull() {

        teamName = null;
    }

    @Test
    void save() throws SQLException {

        when(dao.save(teamName)).thenReturn(teamName.getId());
        assertEquals(teamName.getId(), dao.save(teamName));
    }

    @Test
    void get() throws SQLException {

        when(dao.get(teamName.getId())).thenReturn(teamName);
        assertEquals(teamName, dao.get(teamName.getId()));
    }

    @Test
    void update() throws SQLException {

        teamName.setName("upd");
        dao.update(teamName);
        when(dao.update(teamName)).thenReturn(teamName.getId());
        assertEquals(teamName.getId(), dao.update(teamName));
    }

    @Test
    void delete() throws SQLException {

        dao.delete(teamName.getId());
        when(dao.get(teamName.getId())).thenReturn(null);
        assertNull(dao.get(teamName.getId()));
    }
}




  