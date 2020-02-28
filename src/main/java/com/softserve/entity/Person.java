package com.softserve.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    public Person(String firstName, String lastName, String passport, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.age = age;

    }

    @OneToMany(mappedBy = "person")
    //@JoinTable(name = "person",  joinColumns = @JoinColumn( name = "visa_id" ))
    private Collection<Visa> visa = new ArrayList<Visa>();

    public Collection<Visa> getVisa() {
        return visa;
    }

    public void setVisa(Collection<Visa> visa) {
        this.visa = visa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return getId() == person.getId() &&
            getAge() == person.getAge() &&
            Objects.equals(getFirstName(), person.getFirstName()) &&
            Objects.equals(getLastName(), person.getLastName()) &&
            Objects.equals(getPassport(), person.getPassport()) &&
            Objects.equals(getVisa(), person.getVisa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPassport(), getAge(), getVisa());
    }
}
