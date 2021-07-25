package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.Team;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.TeamDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TeamServiceImplTest {

    @Mock
    private final EntityDAO dao = mock(TeamDAO.class);

    private Team team;

    @BeforeEach
    public void initializeEntities() {

        team = new Team();
        team.setId(1L);
        team.setTeamNameId(1L);
        team.setEmployerId(1L);
    }

    @AfterEach
    public void makeEntitiesNull() {

        team = null;
    }

    @Test
    void save() throws SQLException {

        when(dao.save(team)).thenReturn(team.getId());
        assertEquals(team.getId(), dao.save(team));
    }

    @Test
    void get() throws SQLException {

        when(dao.get(team.getId())).thenReturn(team);
        assertEquals(team, dao.get(team.getId()));
    }

    @Test
    void update() throws SQLException {

        team.setEmployerId(2L);
        dao.update(team);
        when(dao.update(team)).thenReturn(team.getId());
        assertEquals(team.getId(), dao.update(team));
    }

    @Test
    void delete() throws SQLException {

        dao.delete(team.getId());
        when(dao.get(team.getId())).thenReturn(null);
        assertNull(dao.get(team.getId()));
    }
}




  