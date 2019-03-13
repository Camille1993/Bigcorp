package com.training.bigcorp.bigcorp.service;

import com.training.bigcorp.bigcorp.config.Monitored;
import com.training.bigcorp.bigcorp.model.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SiteServiceImpl implements SiteService {
    private final static Logger logger = LoggerFactory.getLogger(SiteService.class);

    private CaptorService captorService;
    @Autowired
    public SiteServiceImpl(CaptorService captorService){
        logger.debug("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
    }

    @Monitored
    @Override

    public Site findById(String siteId) {
        logger.debug("Appel de findbyID" + this);
        if(siteId ==null){
            return  null;
        }

        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }

}
