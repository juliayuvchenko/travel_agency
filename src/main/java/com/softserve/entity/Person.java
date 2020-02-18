package com.softserve.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String passport;
    @Column
    private int age;

    public Person(){
    }

    public Person(String firstName, String lastName, String passport, int age, int visa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.age = age;

    }

    @OneToMany( mappedBy = "person")
    //@JoinTable(name = "person",  joinColumns = @JoinColumn( name = "visa_id" ))
    private Collection<Visa> visa = new ArrayList<Visa>();

    public Collection<Visa> getVisa() {
        return visa;
    }

    public void setVisa(Collection<Visa> visa) {
        this.visa = visa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
