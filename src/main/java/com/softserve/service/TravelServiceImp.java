package com.softserve.service;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TravelServiceImp implements TravelService {
private final SessionFactory sessionFactory;
public static TravelService travelService = new TravelServiceImp();

    public TravelServiceImp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    @Override
    public List<Country> findCountry() {
        return null;
    }

    @Override
    public List<Hotel> findHotelByCity(City city) {
        try(Session session = sessionFactory.openSession();){
            String sql = "select * from hotels where id_city=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Hotel.class);
            query.setParameter("id", city.getId());
          return query.list();
        }
        catch (Exception e){
            System.out.println("Failed findHotelByCity" + city);
            throw e;
        }
    }

    @Override
    public boolean findHotelByDate(Hotel hotel, LocalDate date) {
        return false;
    }

    @Override
    public List<Hotel> findAvailableHotel(City city, LocalDate date) {
        return null;
    }

    @Override
    public List<Visa> amountOfVisaPerson(Person person) {
        return null;
    }

    @Override
    public int amountOfVisaCountry(Country country) {
        return 0;
    }

    @Override
    public boolean bookHotelForPerson(Person person, Hotel hotel, LocalDate date) {
        return false;
    }
}
