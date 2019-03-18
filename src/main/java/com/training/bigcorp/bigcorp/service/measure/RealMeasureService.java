package com.training.bigcorp.bigcorp.service.measure;

import com.training.bigcorp.bigcorp.config.properties.BigCorpApplicationMeasureProperties;
import com.training.bigcorp.bigcorp.config.properties.BigCorpApplicationProperties;
import com.training.bigcorp.bigcorp.model.Captor;
import com.training.bigcorp.bigcorp.model.Measure;
import com.training.bigcorp.bigcorp.model.MeasureStep;
import com.training.bigcorp.bigcorp.model.RealCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RealMeasureService implements MeasureService<RealCaptor> {
    @Autowired
    private BigCorpApplicationProperties properties;

    @Override
    public List<Measure> readMeasures(RealCaptor captor, Instant start, Instant end,
                                      MeasureStep step) {
       checkReadMeasuresAgrs(captor, start, end, step);
        List<Measure> measures = new ArrayList<>();
        Instant current = start;
        while(current.isBefore(end)){
            measures.add(new Measure(current, properties.getMeasure().getDefaultReal(), captor));
            current = current.plusSeconds(step.getDurationInSeconds());
        }
        return measures;
    }
}
