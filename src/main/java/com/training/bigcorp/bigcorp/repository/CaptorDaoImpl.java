package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Captor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CaptorDaoImpl implements CaptorDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void persist(Captor captor) {
        em.persist(captor);
    }

    public List<Captor> findAll() {
        try {
            return em.createQuery("select c from Captor c", Captor.class)
                    .getResultList();
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Captor findById(String id) {
        try {
            return em.find(Captor.class, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Captor> findBySiteId(String siteId) {
        return em.createQuery("select c from Captor c inner join c.site s where s.id = :site_id", Captor.class)
                .setParameter("site_id", siteId)
                .getResultList();
    }

    @Override
    public void delete(Captor captor) {
        em.remove(captor);

    }

}

