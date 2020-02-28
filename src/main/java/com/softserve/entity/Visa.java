package com.softserve.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "visa")
@Entity
public class Visa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private java.sql.Date issue;
    @Column
    private java.sql.Date expiration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn( name = "id_country")
    private Country country;

    public Visa() {
    }

    public Visa( java.sql.Date issue, java.sql.Date expiration) {
    public Visa(java.sql.Date issue, java.sql.Date expiration) {
        this.issue = issue;
        this.expiration = expiration;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.sql.Date getIssue() {
        return issue;
    }

    public void setIssue(java.sql.Date issue) {
        this.issue = issue;
    }

    public java.sql.Date getExpiration() {
        return expiration;
    }

    public void setExpiration(java.sql.Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visa)) return false;
        Visa visa = (Visa) o;
        return getId() == visa.getId() &&
                Objects.equals(getIssue(), visa.getIssue()) &&
                Objects.equals(getExpiration(), visa.getExpiration()) &&
                Objects.equals(getPerson(), visa.getPerson());
    //    public String getIssue() {
//        return issue;
//    }
//
//    public void setIssue(String issue) {
//        this.issue = issue;
//    }
//
//    public String getExpiration() {
//        return expiration;
//    }
//
//    public void setExpiration(String expiration) {
//        this.expiration = expiration;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Visa)) {
            return false;
        }
        Visa visa = (Visa) o;
        return getId() == visa.getId() &&
            Objects.equals(getIssue(), visa.getIssue()) &&
            Objects.equals(getExpiration(), visa.getExpiration()) &&
            Objects.equals(getPerson().getId(), visa.getPerson().getId()) &&
            Objects.equals(getCountry().getId(), visa.getCountry().getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getIssue(), getExpiration(), getPerson());

        return Objects.hash(getId(), getIssue(), getExpiration(), getPerson(), getCountry());
    }

    @Override
    public String toString() {
        return "Visa{" +
            "id=" + id +
            ", issue=" + issue +
            ", expiration=" + expiration +
            ", person=" + person +
            ", country=" + country +
            '}';

    }
}
