package com.softserve.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private java.sql.Date checkin;
    @Column
    private java.sql.Date checkout;
    @Column
    private int quantity;
    @Column
    private Rooms.Luxury luxury;
    @Column
    private Rooms.Bedrooms bedrooms;

    public Bookings() {
    }

    public Bookings(java.sql.Date checkin, java.sql.Date checkout, int quantity,
                    Rooms.Luxury luxury, Rooms.Bedrooms bedrooms, City city) {
        this.checkout = checkout;
        this.checkin = checkin;
        this.quantity = quantity;
        this.luxury = luxury;
        this.bedrooms = bedrooms;
        this.city = city;
    }

    @OneToMany
    private Collection<Rooms> room = new ArrayList<Rooms>();

    @OneToOne
    @JoinColumn(name = "id_city")
    private City city;

    @OneToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Rooms.Luxury getLuxury() {
        return luxury;
    }

    public void setLuxury(Rooms.Luxury luxury) {
        this.luxury = luxury;
    }

    public Rooms.Bedrooms getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Rooms.Bedrooms bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Collection<Rooms> getRoom() {
        return room;
    }

    public void setRoom(Collection<Rooms> room) {
        this.room = room;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bookings)) {
            return false;
        }
        Bookings bookings = (Bookings) o;
        return getId() == bookings.getId() &&
            getQuantity() == bookings.getQuantity() &&
            Objects.equals(getCheckin(), bookings.getCheckin()) &&
            Objects.equals(getCheckout(), bookings.getCheckout()) &&
            getLuxury() == bookings.getLuxury() &&
            getBedrooms() == bookings.getBedrooms() &&
            Objects.equals(getRoom(), bookings.getRoom()) &&
            Objects.equals(getCity(), bookings.getCity()) &&
            Objects.equals(getHotel(), bookings.getHotel()) &&
            Objects.equals(getPerson(), bookings.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCheckin(), getCheckout(), getQuantity(), getLuxury(), getBedrooms(), getRoom(), getCity(), getHotel(), getPerson());
    }
}
