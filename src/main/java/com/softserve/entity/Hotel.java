package com.softserve.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotels")
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int star_rating;
    private String property_type;

}
