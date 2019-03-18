package com.training.bigcorp.bigcorp.service.measure;

import com.training.bigcorp.bigcorp.model.Captor;
import com.training.bigcorp.bigcorp.model.Measure;
import com.training.bigcorp.bigcorp.model.MeasureStep;


import java.time.Instant;
import java.util.List;

public interface MeasureService<T extends Captor> {
    List<Measure> readMeasures(T captor, Instant start, Instant end, MeasureStep step);

    default void checkReadMeasuresAgrs(T captor, Instant start, Instant end, MeasureStep step){
        if(captor == null){
            throw  new IllegalArgumentException("captor is required");
        }
        if(start == null){
            throw new IllegalArgumentException("start is required");
        }
        if(end == null){
            throw new  IllegalArgumentException("end is required");
        }
        if(step == null){
            throw new IllegalArgumentException("step is required");
        }
        if(start.isAfter(end)){
            throw new IllegalArgumentException("start must be before end");
        }
    }

}
