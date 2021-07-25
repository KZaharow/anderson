package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.Project;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.ProjectDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectServiceImplTest {

    @Mock
    private final EntityDAO dao = mock(ProjectDAO.class);

    private Project project;

    @BeforeEach
    public void initializeEntities() {

        project = new Project();
        project.setId(1L);
        project.setName("test");
        project.setCostumer("test");
        project.setFinishDate(new Date());
        project.setMethodology("test");
        project.setProjectManager("test");
        project.setTeamNameId(1L);
    }

    @AfterEach
    public void makeEntitiesNull() {

        project = null;
    }

    @Test
    void save() throws SQLException {

        when(dao.save(project)).thenReturn(project.getId());
        assertEquals(project.getId(), dao.save(project));
    }

    @Test
    void get() throws SQLException {

        when(dao.get(project.getId())).thenReturn(project);
        assertEquals(project, dao.get(project.getId()));
    }

    @Test
    void update() throws SQLException {

        project.setName("new");
        dao.update(project);
        when(dao.update(project)).thenReturn(project.getId());
        assertEquals(project.getId(), dao.update(project));
    }

    @Test
    void delete() throws SQLException {

        dao.delete(project.getId());
        when(dao.get(project.getId())).thenReturn(null);
        assertEquals(null, dao.get(project.getId()));
    }
}




  