package com.training.bigcorp.bigcorp.repository;

import com.training.bigcorp.bigcorp.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;


interface SiteDao extends JpaRepository<Site, String> {

}
