package com.softserve.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "visa")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Visa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int visa_number;
    @Column
    private Date issue;
    @Column
    private Date expiration;
}
