package com.training.bigcorp.bigcorp.service.measure;

import com.training.bigcorp.bigcorp.model.Measure;
import com.training.bigcorp.bigcorp.model.MeasureStep;
import com.training.bigcorp.bigcorp.model.SimulatedCaptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class SimulatedMeasureService implements MeasureService<SimulatedCaptor> {
    private RestTemplate restTemplate;

    public SimulatedMeasureService(RestTemplateBuilder builder){
        this.restTemplate = builder.setConnectTimeout(1000).build();
    }

        @Override
    public List<Measure> readMeasures(SimulatedCaptor captor, Instant start, Instant end,
                                      MeasureStep step) {
        checkReadMeasuresAgrs(captor, start, end, step);
            UriComponentsBuilder builder = UriComponentsBuilder
                    .fromUriString("http://localhost:8090/measures")
                    .path("")
                    .queryParam("start", start)
                    .queryParam("end", end)
                    .queryParam("min", captor.getMinPowerInWatt())
                    .queryParam("max", captor.getMaxPowerInWatt())
                    .queryParam("step", step.getDurationInSeconds());

            Measure[] measures = this.restTemplate.getForObject(builder.toUriString(), Measure[].class);
        return Arrays.asList(measures);
    }
}
