package com.softserve.dao.interfaces;

import com.softserve.entity.Person;

import java.util.Optional;
import java.util.Set;

public interface PersonDao extends Read<Person> {
    Person save(Person person);
    Set<Person> findAll();

    Optional<Person> findById(Long personId);

    Optional<Person> findByLastName(String lastName);

}
