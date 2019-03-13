package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Captor;

import java.util.List;

public interface CaptorDao extends CrudDao<Captor, String> {
    List<Captor> findBySiteId(String siteId);

}
