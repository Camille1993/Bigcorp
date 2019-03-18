package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MeasureDao extends JpaRepository<Measure, Long> {
    void deleteByCaptorId(String captorId);

}
