package com.softserve.service;

import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Visa;
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
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from countries";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Country.class);
            return query.list();
        } catch (Exception e) {
            System.out.println("Failed findCountry");
            throw e;
        }
    }

    @Override
    public List<Hotel> findHotelByCity(String city) {
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from hotels inner join cities on hotels.id_city=cities.id where city=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Hotel.class);
            query.setParameter("id", city);
            return query.list();
        } catch (Exception e) {
            System.out.println("Failed findHotelByCity" + city);
            throw e;
        }
    }

    @Override
    public boolean findHotelByDate(Bookings bookings) {
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from (((bookings join bookings_rooms on bookings.id=bookings_rooms.bookings_id) " +
                "join rooms on rooms.id=bookings_rooms.room_id) " +
                "join hotels on rooms.id_hotel=hotels.id) where hotels.id=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Bookings.class);
            query.setParameter("id", bookings.getHotel().getId());
            List<Bookings> bookingsList = query.list();
            return Bookings.ifPossibleToBook(bookingsList, bookings);
        } catch (Exception e) {
            System.out.println("Failed amountOfVisaPerson" + bookings.getHotel());
            throw e;
        }
    }

    @Override
    public List<Hotel> findAvailableHotel(Bookings bookings) {
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from (((bookings join bookings_rooms on bookings.id=bookings_rooms.bookings_id) " +
                "join rooms on rooms.id=bookings_rooms.room_id) " +
                "join hotels on rooms.id_hotel=hotels.id) where hotels.id_city=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Bookings.class);
            query.setParameter("id", bookings.getCity().getId());
            List<Bookings> bookingsList = query.list();
            return Bookings.whichHotelPossibleToBook(bookingsList, bookings);
        } catch (Exception e) {
            System.out.println("Failed findAvailableHotel");
            throw e;
        }
    }

    @Override
    public List<Visa> amountOfVisaPerson(String firstName, String lastName) {
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from visa join person on visa.id_person=person.id where firstName=:firstName " +
                "and lastName=:lastName";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Visa.class);
            query.setParameter("firstName", firstName );
            query.setParameter("lastName", lastName );
            return query.list();
        } catch (Exception e) {
            System.out.println("Failed amountOfVisaPerson" );
            throw e;
        }
    }

    @Override
    public List<Visa> amountOfVisaCountry(String country) {
        try (Session session = sessionFactory.openSession()) {
            String sql = " select * from visa left join countries on visa.id_country= countries.id where country=:country";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Visa.class);
            query.setParameter("country", country);
            return query.list();
        } catch (Exception e) {
            System.out.println("Failed amountOfVisaPerson" + country);
            throw e;
        }
    }

    @Override
    public boolean bookHotelForPerson(Bookings bookings)  {
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from (((bookings join bookings_rooms on bookings.id=bookings_rooms.bookings_id) " +
                "join rooms on rooms.id=bookings_rooms.room_id) " +
                "join hotels on rooms.id_hotel=hotels.id)where bookings.id_person=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Bookings.class);
            query.setParameter("id", bookings.getPerson().getId());
            List<Bookings> bookingsList = query.list();
            return Bookings.ifPossibleToBook(bookingsList, bookings);
        } catch (Exception e) {
            System.out.println("Failed amountOfVisaPerson" + bookings.getHotel());
            throw e;
        }
    }
@Override
    public List<City> findCity(String city) {
        try (Session session = sessionFactory.openSession()) {
            String sql = "select * from cities where city =:city";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(City.class);
            query.setParameter("city",city);
            return query.list();
        } catch (Exception e) {
            System.out.println("Failed findCountry");
            throw e;
        }
    }

}
