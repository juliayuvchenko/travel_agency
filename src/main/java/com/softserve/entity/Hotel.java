package com.softserve.entity;

import java.util.Objects;
import javax.persistence.Column;
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
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private int star_rating;
    @Column
    private int distance_from_center;
    @Column
    private String property_type;

    public Hotel() {
    }

    public Hotel(String name, int star_rating, int distance_from_center, String property_type) {
        this.name = name;
        this.star_rating = star_rating;
        this.distance_from_center = distance_from_center;
        this.property_type = property_type;
    }

    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hotel)) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return getId() == hotel.getId() &&
            getStar_rating() == hotel.getStar_rating() &&
            distance_from_center == hotel.distance_from_center &&
            Objects.equals(getName(), hotel.getName()) &&
            Objects.equals(getProperty_type(), hotel.getProperty_type()) &&
            Objects.equals(getCity(), hotel.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStar_rating(), distance_from_center, getProperty_type(), getCity());
    }
}
