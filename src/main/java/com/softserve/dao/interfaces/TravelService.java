package com.softserve.dao.interfaces;

import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;

import java.awt.print.Book;
import java.util.List;

public interface TravelService {


        public List<Country> findCountry();

        public List<Hotel> findHotelByCity(City city);

        public boolean findHotelByDate(Bookings bookings);

        public List<Hotel> findAvailableHotel(Bookings bookings);

        public  List<Visa> amountOfVisaPerson(Person person);

        public int amountOfVisaCountry(Country country);

        public boolean bookHotelForPerson(Person person, Hotel hotel, java.sql.Date date);

}
