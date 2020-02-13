package com.softserve;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Rooms;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.CurrencyType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.softserve.entity.Rooms.Bedrooms.APARTMENT;
import static com.softserve.entity.Rooms.Bedrooms.DOUBLE;
import static com.softserve.entity.Rooms.Luxury.BUSINESS;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static SessionFactory sessionFactory = null;

    @BeforeClass
    public static void setUp() throws Exception
    {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Rooms").executeUpdate();
        session.createQuery("DELETE FROM Hotel").executeUpdate();
        session.createQuery("DELETE FROM City").executeUpdate();
        session.createQuery("DELETE FROM Country").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @AfterClass
    public static void tearDown() throws Exception
    {
        sessionFactory.close();
    }

    @Test
    public void testSaveCountries()
    {
        System.out.println( "testSaveOperation begins ........ This is \"C\" of CRUD" );

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country( "Ukraine");
        Country country2 = new Country( "USA" );
        session.save( country );
        session.save( country2 );

        session.getTransaction().commit();
        session.close();
        System.out.println( "testSaveOperation ends ......." );

    }

    @Test
    public void testSaveCity(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country( "Ukraine");
        session.save( country );
        Country country2 = new Country( "USA" );
        session.save( country2 );

        City lviv = new City("Lviv");
        lviv.setCountry(country);
        session.save(lviv);
        City kyiv = new City("Kyiv");
        kyiv.setCountry(country);
        session.save(kyiv);

        session.getTransaction().commit();
        session.close();
        System.out.println( "testSaveOperation ends ......." );

    }

    @Test
    public void testSaveHotel(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country( "Ukraine");
        session.save(country);

        City lviv = new City("Lviv");
        lviv.setCountry(country);
        session.save(lviv);
        City kyiv = new City("Kyiv");
        kyiv.setCountry(country);
        session.save(kyiv);

        Hotel h1 = new Hotel("Hilton", 4, 4, "hotel");
        h1.setCity(kyiv);
        session.save(h1);

        Hotel h2 = new Hotel("GrandHotel", 5, 1,"hotel");
        h2.setCity(lviv);
        session.save(h2);

        session.getTransaction().commit();
        session.close();
        System.out.println( "testSaveOperation ends ......." );

    }

    @Test
    public void testSaveRooms(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country( "Ukraine");
        session.save(country);
        City lviv = new City("Lviv");
        lviv.setCountry(country);
        session.save(lviv);
        Hotel h2 = new Hotel("GrandHotel", 5, 1,"hotel");
        h2.setCity(lviv);
        session.save(h2);

        Rooms r1 = new Rooms(1, BUSINESS, DOUBLE);
        r1.setHotel(h2);
        session.save(r1);

        Rooms r2 = new Rooms(2, BUSINESS, APARTMENT);
        r2.setHotel(h2);
        session.save(r2);

        session.getTransaction().commit();
        session.close();
        System.out.println( "testSaveOperation ends ......." );

    }



}
