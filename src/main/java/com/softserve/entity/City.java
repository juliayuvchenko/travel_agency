package com.softserve.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String city;

    public City() {
    }

    public City(String city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return getId() == city1.getId() &&
                Objects.equals(getCity(), city1.getCity()) &&
                Objects.equals(getCountry(), city1.getCountry());
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }
        City city1 = (City) o;
        return getId() == city1.getId() &&
            Objects.equals(getCity(), city1.getCity()) &&
            Objects.equals(getCountry(), city1.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity(), getCountry());
    }
}
