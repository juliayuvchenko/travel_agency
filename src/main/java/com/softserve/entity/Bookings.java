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

    public Bookings() {
    }

    public Bookings(java.sql.Date checkin,java.sql.Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @OneToMany(mappedBy = "booking")
    private Collection<Rooms> room = new ArrayList<Rooms>();

    @OneToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public Collection<Rooms> getRoom() {
        return room;
    }

    public void setRoom(Collection<Rooms> room) {
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.sql.Date getCheckin() {
        return checkin;
    }

    public void setCheckin(java.sql.Date checkin) {
        this.checkin = checkin;
    }

    public java.sql.Date getCheckout() {
        return checkout;
    }

    public void setCheckout(java.sql.Date checkout) {
        this.checkout = checkout;
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
            Objects.equals(getCheckin(), bookings.getCheckin()) &&
            Objects.equals(getCheckout(), bookings.getCheckout()) &&
            Objects.equals(getRoom(), bookings.getRoom()) &&
            Objects.equals(getHotel(), bookings.getHotel()) &&
            Objects.equals(getPerson(), bookings.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCheckin(), getCheckout(), getRoom(), getHotel(), getPerson());
    }
}
