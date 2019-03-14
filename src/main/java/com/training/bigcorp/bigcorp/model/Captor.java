package com.training.bigcorp.bigcorp.model;

import javax.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Captor {
    /**
     * Captor id
     */
    @Id
    private String id = UUID.randomUUID().toString();

    /**
     * Captor name
     */
    @Column(nullable = false)
    private String name;

    /**
     * Captor powerSource
     */


    @Enumerated(EnumType.STRING)
    private PowerSource powerSource;

    @Column
    private Integer defaultPowerInWatt;

    @ManyToOne
    private Site site;

    @Deprecated
    public Captor() {
        // Use for serializer or deserializer
    }

    /**
     * Constructor to use with required property
     *
     * @param name
     */
    public Captor(String name, PowerSource powerSource, Site site) {
        this.site = site;
        this.name = name;
        this.powerSource = powerSource;
    }

    public Captor(String name, PowerSource powerSource) {
        this.powerSource = powerSource;
        this.name = name;
    }

    public Captor(String name, Site site) {
        this.site = site;
        this.name = name;
    }
    public Captor(String name, Site site, PowerSource powerSource, Integer defaultPowerInWatt){
        this.site = site;
        this.name = name;
        this.defaultPowerInWatt =defaultPowerInWatt;
        this.powerSource = powerSource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource() {
        this.powerSource = powerSource;
    }
    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }
    public Site getSite() {
        return site;
    }
    public void setSite(Site site) {
        this.site = site;
    }


    public Integer getDefaultPowerInWatt() {
        return defaultPowerInWatt;
    }

    public void setDefaultPowerInWatt(Integer defaultPowerInWatt) {
        this.defaultPowerInWatt = defaultPowerInWatt;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Captor site = (Captor) o;
        return Objects.equals(name, site.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Captor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
