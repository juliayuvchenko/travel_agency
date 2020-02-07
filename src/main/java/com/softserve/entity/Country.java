package com.softserve.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "countries")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String country;
    private Set<City> cities;
    }
