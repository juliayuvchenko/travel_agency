package com.softserve.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private int iD;
    private String firstName;
    private String lastName;
    private String passport;
    private int age;
    private int visa;

    public Person() {
    }

    public Person(int iD, String firstName, String lastName, String passport, int age, int visa) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.age = age;
        this.visa = visa;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
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

    public int getVisa() {
        return visa;
    }

    public void setVisa(int visa) {
        this.visa = visa;
    }

    @Override
    public String toString() {
        return "Person{" +
                "iD=" + iD +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport='" + passport + '\'' +
                ", age=" + age +
                ", visa=" + visa +
                '}';
    }
}
