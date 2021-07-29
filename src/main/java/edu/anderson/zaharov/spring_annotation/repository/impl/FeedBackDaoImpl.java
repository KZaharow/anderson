package edu.anderson.zaharov.spring_annotation.repository.impl;

import edu.anderson.zaharov.spring_annotation.entity.FeedBack;
import edu.anderson.zaharov.spring_annotation.repository.FeedBackDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
public class FeedBackDaoImpl implements FeedBackDao {

    private final SessionFactory sessionFactory;

    @Override
    public long saveOrUpdateEntityById(FeedBack feedBack) {

        sessionFactory.getCurrentSession().saveOrUpdate(feedBack);
        Long id = feedBack.getId();
        log.info(" ** --> Entity has been saved: {}", feedBack);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public FeedBack findEntityById(long id) {

        FeedBack feedBack = (FeedBack) sessionFactory.getCurrentSession().
                getNamedQuery("FeedBac").
                setParameter("id", id).uniqueResult();
        log.info(" ** --> Entity has been found: {}", feedBack);
        return feedBack;
    }

    @Override
    public void deleteEntityByName(FeedBack feedBack) {

        sessionFactory.getCurrentSession().delete(feedBack);
        log.info(" ** --> Entity has been deleted: {}", feedBack);
    }
}
