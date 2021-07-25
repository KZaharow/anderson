package edu.anderson.zaharov.service.impl;

import edu.anderson.zaharov.entity.FeedBack;
import edu.anderson.zaharov.repository.EntityDAO;
import edu.anderson.zaharov.repository.impl.FeedBackDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FeedBackServiceImplTest {

    @Mock
    private final EntityDAO dao = mock(FeedBackDAO.class);

    private FeedBack feedBack;

    @BeforeEach
    public void initializeEntities() {

        feedBack = new FeedBack();
        feedBack.setId(1L);
        feedBack.setText("test");
        feedBack.setDate(new Date());
    }

    @AfterEach
    public void makeEntitiesNull() {

        feedBack = null;
    }

    @Test
    void save() throws SQLException {

        when(dao.save(feedBack)).thenReturn(feedBack.getId());
        assertEquals(feedBack.getId(), dao.save(feedBack));
    }

    @Test
    void get() throws SQLException {

        when(dao.get(feedBack.getId())).thenReturn(feedBack);
        assertEquals(feedBack, dao.get(feedBack.getId()));
    }

    @Test
    void update() throws SQLException {

        feedBack.setText("upd!");
        dao.update(feedBack);
        when(dao.update(feedBack)).thenReturn(feedBack.getId());
        assertEquals(feedBack.getId(), dao.update(feedBack));
    }

    @Test
    void delete() throws SQLException {

        dao.delete(feedBack.getId());
        when(dao.get(feedBack.getId())).thenReturn(null);
        assertEquals(null, dao.get(feedBack.getId()));
    }
}




  