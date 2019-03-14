package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Captor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CaptorDao extends JpaRepository<Captor, String>, CaptorCustomDao {
    List<Captor> findBySiteId(String siteId);
}
