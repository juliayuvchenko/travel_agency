package com.softserve.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visa")
public class Visa implements Serializable {
    private int id;
    private int visa_number;
    private LocalDate issue;
    private LocalDate expiration;

}
