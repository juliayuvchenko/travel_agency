package com.softserve.service;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import jdk.vm.ci.meta.Local;

public interface TravelService {

public List<Country> findCountry();

public List<Hotel> findHotelByCity(City city);

public boolean findHotelByDate(Hotel hotel, LocalDate date);

public List<Hotel> findAvailableHotel(City city, LocalDate date);

public  List<Visa> amountOfVisaPerson(Person person);

public int amountOfVisaCountry(Country country);

public boolean bookHotelForPerson(Person person, Hotel hotel, LocalDate date);

}
