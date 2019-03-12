package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Captor;

import java.util.List;
import java.util.stream.Collectors;

public interface CaptorDao extends CrudDao<Captor, String> {
    List<Captor> findBySiteId(String siteId);

}
