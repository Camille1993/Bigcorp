package com.training.bigcorp.bigcorp.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Measure {

    @Id
    @GeneratedValue
    private Long Id;
    /**
     *  When the measure date had been read
     */
    @NotNull
    @Past
   private Instant instant;
    /**
     * measures values in Watt
     */
    @NotNull
    private Integer valueInWatt;
    /**
     * Captor where the measure had been made
     */
    @Valid
    @ManyToOne(optional = false)
    private Captor captor;

    @Version
    private int version;

    @Deprecated
    public Measure() {
        // Use for serializer or deserializer
    }
    public Measure( Instant instant, Integer valueInWatt, Captor captor){
        this.instant = instant;
        this.valueInWatt = valueInWatt;
        this.captor = captor;
    }

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

    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
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
