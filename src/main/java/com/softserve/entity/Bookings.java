package com.softserve.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookings  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int id_person;
    @Column
    private Date checkin;
    @Column
    private Date checkout;
    @Column
    private int id_room;
    @Column
    private int id_hotel;
    private Person person;
    private Rooms rooms;
}
