package com.softserve.entity;

<<<<<<< HEAD
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
=======
>>>>>>> origin/yurabranch
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
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

=======
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
>>>>>>> origin/yurabranch
}
