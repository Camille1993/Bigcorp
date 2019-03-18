package com.training.bigcorp.bigcorp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.bigcorp.bigcorp.controller.dto.MeasureDto;
import com.training.bigcorp.bigcorp.model.*;
import com.training.bigcorp.bigcorp.service.measure.SimulatedMeasureService;
import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@RunWith(SpringRunner.class)
@RestClientTest(SimulatedMeasureService.class)
public class SimulatedMeasureServiceTest {

    @Autowired
    private SimulatedMeasureService service;
    @Autowired
    private MockRestServiceServer server;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Captor used in tests
     */
    private SimulatedCaptor captor = new SimulatedCaptor("test", new Site("Florange"), 500_000, 1_000_000);

    @Test
    public void readMeasures() throws Exception {
        Instant start = Instant.parse("2018-09-01T22:00:00Z");
        Instant end = Instant.parse("2018-09-01T22:30:00Z");

        List<MeasureDto> expectedMeasures = Arrays.asList(
                new MeasureDto(Instant.parse("2018-09-01T22:00:00Z"), 1234),
                new MeasureDto(Instant.parse("2018-09-01T22:30:00Z"), 4567)
        );

        String expectedJson = objectMapper.writeValueAsString(expectedMeasures);
        String request = "http://localhost:8090/measures?start=2018-09-01T22:00:00Z&" +
                "end=2018-09-01T22:30:00Z&min=500000&max=1000000&step=3600";

        this.server.expect(MockRestRequestMatchers.requestTo(request))
                .andRespond(MockRestResponseCreators.withSuccess(expectedJson,
                        MediaType.APPLICATION_JSON));

        List<Measure> measures = service.readMeasures(captor, start, end,
                MeasureStep.ONE_HOUR);

        assertThat(measures).hasSize(2);
// And we have a value for each hour of the period
        assertThat(measures)
                .extracting("instant", "valueInWatt")
                .containsExactly(
                        Tuple.tuple(Instant.parse("2018-09-01T22:00:00Z"), 1234),
                        Tuple.tuple(Instant.parse("2018-09-01T22:30:00Z"), 4567)
                );
    }
}