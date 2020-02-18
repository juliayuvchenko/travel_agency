package com.softserve;

import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Rooms;
import com.softserve.entity.Visa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
        session.createQuery("DELETE FROM Bookings").executeUpdate();
        session.createQuery("DELETE FROM Visa").executeUpdate();
        session.createQuery("DELETE FROM Person").executeUpdate();
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
    @Test
    public void testSaveVisa() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person("Lolik", "Zhukin", "FD23111", 30, 2);
        session.save(person);
        Person person2 = new Person("Julia", "Maksimiv", "KT45231", 25, 1);
        session.save(person2);
        Person person3 = new Person("Alex", "Rosa", "KL34112", 45, 3);
        session.save(person3);

        Country c_usa = new Country("USA");
        session.save(c_usa);
        Country c_poland = new Country("Poland");
        session.save(c_poland);

        Visa usa1 = new Visa("2018-05-05", "2028-11-20");
        usa1.setCountry(c_usa);
        usa1.setPerson(person);
        session.save(usa1);

        Visa usa2 = new Visa("2018-05-05", "2028-11-20");
        usa2.setCountry(c_usa);
        usa2.setPerson(person2);
        session.save(usa2);

        Visa poland = new Visa("2019-06-21", "2020-06-25");
        poland.setPerson(person);
        poland.setCountry(c_poland);
        session.save(poland);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveBookings() {
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
        Person person = new Person("Lolik", "Zhukin", "FD23111", 30, 2);
        session.save(person);
        Rooms r1 = new Rooms(1, BUSINESS, DOUBLE);
        r1.setHotel(h2);



        Bookings book = new Bookings("2020-05-16", "2020-06-16");
        book.setHotel(h2);
        //book.getRoom().add(r1);
        book.setPerson(person);
       r1.setBooking(book);
        session.save(r1);
        session.save(book);

        session.getTransaction().commit();
        session.close();
    }


}
