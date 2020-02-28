package com.softserve.dao.interfaces;

import com.softserve.entity.Country;

import java.util.List;
import java.util.Optional;


public interface CountryDao extends Read<Country> {
    List<Country> findAll();

    Optional<Country> findById(Country country);

    List<Country> findCountriesVisitedByPerson(Long personId);

    Optional<Country> findByCountryName(String country);
}
