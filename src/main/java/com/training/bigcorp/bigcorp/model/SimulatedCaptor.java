package com.training.bigcorp.bigcorp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("SIMULATED")
public class SimulatedCaptor extends Captor {
    @NotNull
    private Integer minPowerInWatt;
    @NotNull
    private Integer maxPowerInWatt;

    @AssertTrue(message = "minPowerInWatt should be less than maxPowerInWatt")
    public boolean isValid(){
        return this.minPowerInWatt<= this.maxPowerInWatt;
    }
    @Deprecated
    public SimulatedCaptor() {
        super();
    }

    public SimulatedCaptor(String name, Site site, Integer minPowerInWatt, Integer maxPowerInWatt) {
        super(name, site);
        this.maxPowerInWatt = maxPowerInWatt;
        this.minPowerInWatt = minPowerInWatt;
    }
}
