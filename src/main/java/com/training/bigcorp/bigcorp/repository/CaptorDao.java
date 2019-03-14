package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Captor;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CaptorDao extends JpaRepository<Captor, String>, CaptorCustomDao {

}
