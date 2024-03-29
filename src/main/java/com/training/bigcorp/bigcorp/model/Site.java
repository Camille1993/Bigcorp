package com.training.bigcorp.bigcorp.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
public class Site {
    /**
     * Site id
     */

    @Id
    private String id;
    @PrePersist
    public void  generateId(){
        this.id =UUID.randomUUID().toString();
    }

    /**
     * Site name
     */
    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    /**
     * Site captors
     */
    @Valid
    @OneToMany(mappedBy = "site")
    private Set<Captor> captors;

    @Version
    private int version;


    public Site() {
        // Use for serializer or deserializer
    }

    /**
     * Constructor to use with required property
     * @param name
     */
    public Site(String name) {
        this.name = name;
    }


    //getters and setters
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

    public Set<Captor> getCaptors() {
        return captors;
    }
    public void setCaptors(Set<Captor> captors) {
        this.captors = captors;
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
        Site site = (Site) o;
        return Objects.equals(name, site.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Site{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", captors=" + captors.stream().map(Captor::getName).collect(Collectors.joining())+
                ", version=" + version +
                "}";
    }
}
