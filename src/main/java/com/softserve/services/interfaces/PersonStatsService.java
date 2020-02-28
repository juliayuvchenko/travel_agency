package com.softserve.services.interfaces;

import com.softserve.entity.Person;

import java.util.Optional;

public interface PersonStatsService {
    Optional<Person> getPerson(String lastName);

}
