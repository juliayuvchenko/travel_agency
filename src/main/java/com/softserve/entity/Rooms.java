package com.softserve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
 class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int room_number;
    @Column
    private Luxury luxury;
    @Column
    private Bedrooms bedrooms;

    public enum Luxury{
        ECONOM, STANDARD, BUSINESS, PREMIUM
    }
    public enum Bedrooms {
        SINGLE, DOUBLE, TRIPLE, APARTMENT
    }
}
