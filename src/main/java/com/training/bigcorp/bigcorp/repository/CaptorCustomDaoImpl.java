package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Captor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CaptorCustomDaoImpl implements CaptorCustomDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Captor> findBySiteId(String siteId){
        return em.createQuery("select c from Captor c inner join c.site s where s.id = :site_id",
                Captor.class)
                .setParameter("site_id", siteId)
                .getResultList();
    }

}
