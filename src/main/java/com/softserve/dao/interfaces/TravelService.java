package com.softserve.dao.interfaces;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;

import java.util.List;

public interface TravelService {


        public List<Country> findCountry();

        public List<Hotel> findHotelByCity(City city);

        public boolean findHotelByDate(Hotel hotel, java.sql.Date date);

        public List<Hotel> findAvailableHotel(City city, java.sql.Date date);

        public  List<Visa> amountOfVisaPerson(Person person);

        public int amountOfVisaCountry(Country country);

        public boolean bookHotelForPerson(Person person, Hotel hotel, java.sql.Date date);

}
