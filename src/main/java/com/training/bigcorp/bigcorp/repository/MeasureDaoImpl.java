package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Measure;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MeasureDaoImpl implements MeasureDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Measure measure) {
        em.persist(measure);
    }

    @Override
    public Measure findById(Long id) {
        try {
            return em.find(Measure.class, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Measure> findAll() {
         try {
            return em.createQuery("select m from Measure m", Measure.class)
                    .getResultList();
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void delete(Measure measure) {
        em.remove(measure);
    }
}
