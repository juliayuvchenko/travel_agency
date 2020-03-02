package com.softserve.service;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;
import java.time.LocalDate;
import java.util.List;

public interface TravelService {

    List<Country> getAllCountries();

    List<Hotel> findHotelByCity(City city);

    boolean findHotelByDate(Hotel hotel,LocalDate date);

    List<Hotel> findAvailableHotel(City city, LocalDate date);

    List<Visa> amountOfVisaPerson(Person person);

    int amountOfVisaCountry(Country country);

    boolean bookHotelForPerson(Person person, Hotel hotel, java.sql.Date date);


}
