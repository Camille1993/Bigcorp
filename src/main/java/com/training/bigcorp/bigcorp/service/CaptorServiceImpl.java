package com.training.bigcorp.bigcorp.service;

import com.training.bigcorp.bigcorp.config.Monitored;
import com.training.bigcorp.bigcorp.model.*;
import com.training.bigcorp.bigcorp.repository.CaptorDao;
import com.training.bigcorp.bigcorp.service.measure.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class CaptorServiceImpl implements CaptorService {
    @Autowired
    private CaptorDao captorDao;

    @Autowired
    private MeasureService fixedMeasureService;
    @Autowired
    private MeasureService realMeasureService;
    @Autowired
    private MeasureService simulatedMeasureService;

    public void setFixedMeasureService(MeasureService fixedMeasureService) {
        this.fixedMeasureService = fixedMeasureService;
    }

    public void setRealMeasureService(MeasureService realMeasureService) {
        this.realMeasureService = realMeasureService;
    }

    public void setSimulatedMeasureService(MeasureService simulatedMeasureService) {
        this.simulatedMeasureService = simulatedMeasureService;
    }

    @Monitored
    @Override

    public Set<Captor> findBySite(String siteId) {
        Set<Captor> listCaptor = captorDao.findBySiteId(siteId).stream().collect(Collectors.toSet());
        return listCaptor;
    }
        public Set<Captor> findBySiteId (String siteId){
            if (siteId == null) {
                return Collections.emptySet();
            }

            Set<Captor> captors = new HashSet<>();
            captors.add(new FixedCaptor("Capteur A", new Site("site"), 1_000_000));
            captors.add(new RealCaptor("Capteur A", new Site("site")));
            captors.add(new SimulatedCaptor("Capteur A", new Site("site"), 500_000, 10_000_000));
            return captors;
        }


}
