package com.softserve.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
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
public class Bookings{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String checkin;
    @Column
    private String checkout;

    public Bookings() {
    }
    public Bookings(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @OneToMany(mappedBy = "booking")
    private Collection<Rooms> room = new ArrayList<Rooms>();

    @OneToOne
    @JoinColumn(name ="id_hotel")
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name ="id_person")
    private Person person;




    public Collection<Rooms> getRoom() {
        return room;
    }

    public void setRoom(Collection<Rooms> room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
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

}
