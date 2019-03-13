package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Site;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SiteDaoImpl implements SiteDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Site site) {
    em.persist(site);
    }

    @Override
    public Site findById(String id) {
        try {
            return em.find(Site.class, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Site> findAll() {
        try {
            return em.createQuery("select s from Site s",Site.class)
                    .getResultList();
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void delete(Site site) {
        em.remove(site);
    }
}

