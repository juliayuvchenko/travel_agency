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

@Table(name = "visa")
@Entity
public class Visa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String issue;
    @Column
    private String expiration;

    public Visa() {
    }

    public Visa(String issue, String expiration) {
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

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
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
            Objects.equals(getPerson(), visa.getPerson()) &&
            Objects.equals(getCountry(), visa.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIssue(), getExpiration(), getPerson(), getCountry());
    }

}
