package com.training.bigcorp.bigcorp.service.measure;

import com.training.bigcorp.bigcorp.config.properties.BigCorpApplicationProperties;
import com.training.bigcorp.bigcorp.model.FixedCaptor;
import com.training.bigcorp.bigcorp.model.Measure;
import com.training.bigcorp.bigcorp.model.MeasureStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class FixedMeasureService implements MeasureService<FixedCaptor> {

    @Autowired
    private BigCorpApplicationProperties properties;

    @Override
    public List<Measure> readMeasures(FixedCaptor captor, Instant start, Instant end, MeasureStep step){
        checkReadMeasuresAgrs(captor, start, end, step);
        List<Measure> measures = new ArrayList<>();
        Instant current = start;
            while(current.isBefore(end)){
                measures.add(new Measure(current, properties.getMeasure().getDefaultFixed(), captor));
                current = current.plusSeconds(step.getDurationInSeconds());
            }
            return measures;
    }

}
