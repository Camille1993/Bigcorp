package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SiteDao extends JpaRepository<Site, String> {

}
