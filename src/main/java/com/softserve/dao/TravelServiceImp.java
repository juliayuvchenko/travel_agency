package com.softserve.dao;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;

import java.util.List;

import com.softserve.dao.interfaces.TravelService;
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
            System.out.println("Failed findHotelByCity" + city);
            throw e;
        }
    }

    @Override
    public boolean findHotelByDate(Hotel hotel, java.sql.Date  date) {
        return false;
    }

    @Override
    public List<Hotel> findAvailableHotel(City city, java.sql.Date date) {
        try (Session session = sessionFactory.openSession()){
            String sql = "select * from hotel where id_city=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Visa.class);
            query.setParameter("id", city.getId());
            return query.list();
        }
        catch (Exception e){
            System.out.println("Failed findAvailableHotel" );
            throw e;
        }
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
        try (Session session = sessionFactory.openSession()){
            String sql = "select * from visa where id_country=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Visa.class);
            query.setParameter("id", country.getId());
            return query.list().size();
        }
        catch (Exception e){
            System.out.println("Failed amountOfVisaPerson" + country);
            throw e;
        }
    }

    @Override
    public boolean bookHotelForPerson(Person person, Hotel hotel, java.sql.Date date) {
        return false;
    }
}