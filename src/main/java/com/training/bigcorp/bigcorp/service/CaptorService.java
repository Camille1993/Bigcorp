package com.training.bigcorp.bigcorp.service;

import com.training.bigcorp.bigcorp.model.Captor;

import java.util.Set;

public interface CaptorService {
    Set<Captor> findBySite(String siteId);


}
