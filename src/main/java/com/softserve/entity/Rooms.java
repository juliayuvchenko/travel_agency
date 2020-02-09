package com.softserve.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rooms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int room_number;
    private Luxury luxury;
    private Bedrooms bedrooms;

    public enum Luxury{
        ECONOM, STANDARD, BUSINESS, PREMIUM
    }
    public enum Bedrooms {
        SINGLE, DOUBLE, TRIPLE, APARTMENT
    }



}
