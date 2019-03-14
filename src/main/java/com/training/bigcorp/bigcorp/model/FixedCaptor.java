package com.training.bigcorp.bigcorp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FIXED")
public class FixedCaptor extends Captor {
    private Integer defaultPowerInWatt;

    @Deprecated
    public FixedCaptor() {
        super();
    }

    public FixedCaptor(String name, Site site, Integer defaultPowerInWatt) {
        super(name, site);
        this.defaultPowerInWatt=defaultPowerInWatt;
    }
}
