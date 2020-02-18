package com.softserve.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String country;

    public Country() {
    }

    public Country( String country) {
        this.country = country;
    }

     @OneToMany( mappedBy = "country")
    private Collection<Visa> visa = new ArrayList<Visa>();

    public Collection<Visa> getVisa() {
        return visa;
    }

    public void setVisa(Collection<Visa> visa) {
        this.visa = visa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}

