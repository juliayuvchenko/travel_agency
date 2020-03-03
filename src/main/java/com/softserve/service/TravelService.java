package com.softserve.service;

import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;
import java.util.List;

public interface TravelService {

    List<Country> findCountry();

    List<Hotel> findHotelByCity(String city);

    boolean findHotelByDate(Bookings bookings);

    List<Hotel> findAvailableHotel(Bookings booking);

    List<Visa> amountOfVisaPerson(String firstName, String lastName);

    List<Visa> amountOfVisaCountry(String country);

    boolean bookHotelForPerson(Bookings bookings);

    List<City> findCity(String city);
}
