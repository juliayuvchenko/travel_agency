package com.softserve.service;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;
import java.util.List;

public interface TravelService {

    List<Country> findCountry();

    List<Hotel> findHotelByCity(City city);

    boolean findHotelByDate(Hotel hotel, java.sql.Date date);

    List<Hotel> findAvailableHotel(City city, java.sql.Date date);

    List<Visa> amountOfVisaPerson(Person person);

    int amountOfVisaCountry(Country country);

    boolean bookHotelForPerson(Person person, Hotel hotel, java.sql.Date date);


}
