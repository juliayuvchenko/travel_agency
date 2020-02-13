package com.softserve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
 public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
   @JoinColumn(name ="id_hotel")
   private Hotel hotel;


   public enum Luxury{
        ECONOM, STANDARD, BUSINESS, PREMIUM
    }
    public enum Bedrooms {
        SINGLE, DOUBLE, TRIPLE, APARTMENT
    }

   public int getId() {
      return id;
   }

   public void setId(int id) {
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
}
