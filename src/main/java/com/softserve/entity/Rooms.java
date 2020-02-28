package com.softserve.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private int room_number;
    @Column
    private Luxury luxury;
    @Column
    private Bedrooms bedrooms;

    public Rooms() {
    }

    public Rooms(int room_number, Luxury luxury, Bedrooms bedrooms) {
        this.room_number = room_number;
        this.luxury = luxury;
        this.bedrooms = bedrooms;
    }

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }

    @ManyToOne
    @JoinTable(name = "bookings_rooms", joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name="bookings_id"))
    private Bookings bookings;

    public enum Luxury {
        ECONOM, STANDARD, BUSINESS, PREMIUM
    }

    public enum Bedrooms {
        SINGLE, DOUBLE, TRIPLE, APARTMENT
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public Luxury getLuxury() {
        return luxury;
    }

    public void setLuxury(Luxury luxury) {
        this.luxury = luxury;
    }

    public Bedrooms getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Bedrooms bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rooms)) {
            return false;
        }
        Rooms rooms = (Rooms) o;
        return getId() == rooms.getId() &&
            getRoom_number() == rooms.getRoom_number() &&
            getLuxury() == rooms.getLuxury() &&
            getBedrooms() == rooms.getBedrooms() &&
            Objects.equals(getHotel(), rooms.getHotel()); //&&
        //Objects.equals(getBooking(), rooms.getBooking());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoom_number(), getLuxury(), getBedrooms(), getHotel());
    }

}
