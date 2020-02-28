package com.softserve.entity;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private Set<Person> guests;

    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_visa")
    private Set<Visa> visas;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_visa")
    private Set<City> cities;*/

    public Country() {
    }

    public Country( String country) {
        this.country = country;
    }

    public Set<Person> getGuests() {
        return guests;
    }

    public void setGuests(Set<Person> guests) {
        this.guests = guests;
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
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country1 = (Country) o;
        return getId() == country1.getId() &&
                Objects.equals(getCountry(), country1.getCountry()); //&&
//                Objects.equals(getVisa(), country1.getVisa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry());
    }
}

