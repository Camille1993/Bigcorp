package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Captor;

import java.util.List;

public interface CaptorCustomDao {
    List<Captor> findBySiteId(String siteId);
}
