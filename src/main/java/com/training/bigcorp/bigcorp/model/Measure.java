package com.training.bigcorp.bigcorp.model;

import java.time.Instant;
import java.util.Objects;

public class Measure {

    private Long Id;
    /**
     *  When the measure date had been read
     */
   private Instant instant;
    /**
     * measures values in Watt
     */
    private Integer valueInWatt;
    /**
     * Captor where the measure had been made
     */
    private Captor captor;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Integer getValueInWatt() {
        return valueInWatt;
    }

    public void setValueInWatt(Integer valueInWatt) {
        this.valueInWatt = valueInWatt;
    }

    public Captor getCaptor() {
        return captor;
    }

    public void setCaptor(Captor captor) {
        this.captor = captor;
    }

    public Measure( Instant instant, Integer valueInWatt, Captor captor){
        this.instant = instant;
        this.valueInWatt = valueInWatt;
        this.captor = captor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measure measure = (Measure) o;
        return instant.equals(measure.instant) &&
                valueInWatt.equals(measure.valueInWatt) &&
                captor.equals(measure.captor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instant, valueInWatt, captor);
    }

    @Override
    public String toString() {
        return "Measure{" +
                "instant=" + instant +
                ", valueInWatt=" + valueInWatt +
                ", captor=" + captor +
                '}';
    }
}
