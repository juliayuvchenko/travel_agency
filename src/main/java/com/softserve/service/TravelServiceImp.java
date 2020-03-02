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
    public List<Country> getAllCountries() {
        try(Session session = sessionFactory.openSession()){
            String sql = "select * from countries";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Country.class);
            return query.list();
        }
        catch (Exception e){
            System.out.println("Failed findCountry");
            throw e;
        }
    }

    @Override
    public List<Hotel> findHotelByCity(City city) {
        try(Session session = sessionFactory.openSession()){
            String sql = "select * from hotels where id_city=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Hotel.class);
            query.setParameter("id", city.getId());
          return query.list();
        }
        catch (Exception e){
            System.out.println("Failed findHotelByCity" + city.getId());
            throw e;
        }
    }

    @Override
    public boolean findHotelByDate(Hotel hotel, LocalDate  date) {
        try (Session session = sessionFactory.openSession()){
            String sql = "select * from bookings where issue=:issue and expiration=";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Visa.class);
            query.setParameter("id", hotel.getId());
             query.list();
        }
        catch (Exception e){
            System.out.println("Failed amountOfVisaPerson" + hotel);
            throw e;
        }


return true;
    }

    @Override
    public List<Hotel> findAvailableHotel(City city, LocalDate date) {
        return null;
    }

    @Override
    public List<Visa> amountOfVisaPerson(Person person) {
        try (Session session = sessionFactory.openSession()){
            String sql = "select * from visa where id_person=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Visa.class);
            query.setParameter("id", person.getId());
            return query.list();
        }
        catch (Exception e){
            System.out.println("Failed amountOfVisaPerson" + person);
            throw e;
        }
    }

    @Override
    public int amountOfVisaCountry(Country country) {
//        try (Session session = sessionFactory.openSession()){
//            String sql = "select * from visa where id_country=:id";
//            SQLQuery query = session.createSQLQuery(sql);
//            query.addEntity(Visa.class);
//            query.setParameter("id", country.getId());
//            return query.list().size();
//        }
//        catch (Exception e){
//            System.out.println("Failed amountOfVisaPerson" + country);
//            throw e;
//        }
        return 1;
    }

    @Override
    public boolean bookHotelForPerson(Person person, Hotel hotel, java.sql.Date date) {
        return false;
    }
}
