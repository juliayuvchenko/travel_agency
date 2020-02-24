package com.softserve.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String country;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "country")
    private Collection<Visa> visa = new ArrayList<Visa>();

    public Collection<Visa> getVisa() {
        return visa;
    }

    public void setVisa(Collection<Visa> visa) {
        this.visa = visa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        Country country1 = (Country) o;
        return getId() == country1.getId() &&
            Objects.equals(getCountry(), country1.getCountry());//&&
         //Objects.equals(getVisa(), country1.getVisa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getVisa());
    }
}

