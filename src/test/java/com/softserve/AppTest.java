package com.softserve;

import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Country;


import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Rooms;
import com.softserve.entity.Visa;
import com.softserve.service.BookingService;
import com.softserve.service.BookingServiceImpl;
import com.softserve.service.TravelService;
import com.softserve.service.TravelServiceImp;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import static com.softserve.entity.Rooms.Bedrooms.DOUBLE;
import static com.softserve.entity.Rooms.Bedrooms.SINGLE;
import static com.softserve.entity.Rooms.Luxury.BUSINESS;
import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest {
    private static SessionFactory sessionFactory = null;
    //  private static TravelService travelService;

    static TravelService travelService;
    static BookingService bookingService;

    @BeforeClass
    public static void setUp() throws Exception {
        travelService = TravelServiceImp.travelService;
        bookingService = BookingServiceImpl.bookingService;

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
    public static void tearDown() throws Exception {
        sessionFactory.close();
    }

    @Test
    public void testSaveCountries() {

        System.out.println("testSaveOperation begins ........ This is \"C\" of CRUD");

        System.out.println("testSaveCountries begins ........ This is \"C\" of CRUD");


        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country("Ukraine");

        Country country2 = new Country("USA");
        session.save(country);
        session.save(country2);

        session.getTransaction().commit();
        session.close();
        System.out.println("testSaveCountries ends .......");
        List<Country> findHotels = travelService.findCountry();

//        assertEquals(2, findHotels.size());

    }


    @Test
    public void testRetrieveCountries() {
        System.out.println("testRetriveCountries begins .......This is \"R\" of CRUD");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = new Country("Ukraine");
        session.save(country);
        session.getTransaction().commit();
        session.close();
        System.out.println("testSaveOperation ends .......");

        List<Country> findCountry = travelService.findCountry();
//        assertEquals(2, findCountry.size());
//        assertEquals(country, (findCountry.get(0)));


        Session session1 = sessionFactory.openSession();
        // session1.beginTransaction();
        Country country1 = session1.get(Country.class, country.getId());

        // session1.getTransaction().commit();
        System.out.println("Retrieved country from DB is " + country);
        session1.close();
        System.out.println("testRetriveCountries ends .......");
    }

    @Test
    public void testSaveCity() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = new Country("Ukraine");
        session.save(country);


        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        // session1.beginTransaction();
        Country country2 = session1.get(Country.class, country.getId());

        // session1.getTransaction().commit();
        System.out.println("Retrieved country from DB is " + country);
        session1.close();
        assertEquals(country.getId(), country2.getId());
        System.out.println("testRetriveCountries ends .......");
    }


    @Test
    public void testSaveHotel() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country("Ukraine");
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

        Hotel h2 = new Hotel("GrandHotel", 5, 1, "hotel");
        h2.setCity(lviv);
        session.save(h2);

        session.getTransaction().commit();
        session.close();
        System.out.println("testSaveOperation ends .......");
        List<Hotel> findHotels = travelService.findHotelByCity(lviv);
        assertEquals(1, findHotels.size());
        assertEquals(h2, (findHotels.get(0)));
        System.out.println("=====================================================================");

    }

//    @Test
//    public void  testAvailableHotel(){
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Country country = new Country("Ukraine");
//        session.save(country);
//        City kyiv = new City("Kyiv");
//        kyiv.setCountry(country);
//        session.save(kyiv);
//        Hotel h1 = new Hotel("Hilton", 4, 4, "hotel");
//        h1.setCity(kyiv);
//        session.save(h1);
//
//        Rooms r1 = new Rooms(1, BUSINESS, DOUBLE);
//        r1.setHotel(h1);
//        session.save(r1);
//        Rooms r2 = new Rooms(1, BUSINESS, DOUBLE);
//        r2.setHotel(h1);
//        session.save(r2);
//
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("testSaveOperation ends .......");
//        assertEquals(false, hotelService.availableHotel(h1));
//
//    }

    @Test
    public void testSaveRooms() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country("Ukraine");
        session.save(country);

        City lviv = new City("Lviv");
        lviv.setCountry(country);
        session.save(lviv);

        City kyiv = new City("Kyiv");
        kyiv.setCountry(country);
        session.save(kyiv);

        Person person = new Person("Lolik", "Zhukin", "FD23111", 30);
        session.save(person);


        Hotel h1 = new Hotel("Hilton", 4, 4, "hotel");
        h1.setCity(kyiv);
        session.save(h1);

        Hotel h2 = new Hotel("GrandHotel", 5, 1, "hotel");
        h2.setCity(lviv);
        session.save(h2);

        session.getTransaction().commit();
        session.close();
        System.out.println("testSaveOperation ends .......");

        List<Hotel> findHotels = travelService.findHotelByCity(lviv);
        assertEquals(1, findHotels.size());
        assertEquals(h2, (findHotels.get(0)));
        System.out.println("=====================================================================");

        Bookings book = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 05, 16)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 16)), 1, BUSINESS,DOUBLE, lviv);
        List<Rooms>roomsForBook =  bookingService.roomsByCriteria(book);
        assertEquals(1, roomsForBook.size());


    }

    @Test
    public void testSaveVisa() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person("Lolik", "Zhukin", "FD23111", 30);
        session.save(person);
        Person person2 = new Person("Julia", "Maksimiv", "KT45231", 25);
        session.save(person2);
        Person person3 = new Person("Alex", "Rosa", "KL34112", 45);
        session.save(person3);

        Country c_usa = new Country("USA");
        session.save(c_usa);
        Country c_poland = new Country("Poland");
        session.save(c_poland);



        LocalDate issue = LocalDate.of(2018, 06, 11);

        Visa usa1 = new Visa(java.sql.Date.valueOf(issue), java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));

        usa1.setCountry(c_usa);
        usa1.setPerson(person);
        session.save(usa1);


        Visa usa2 = new Visa(java.sql.Date.valueOf(LocalDate.of(2018, 5, 5)),
                java.sql.Date.valueOf(LocalDate.of(2028, 11, 20)));
                usa2.setCountry(c_usa);
        usa2.setPerson(person2);
        session.save(usa2);


        Visa poland = new Visa(java.sql.Date.valueOf(LocalDate.of(2019, 6, 21)),
                java.sql.Date.valueOf(LocalDate.of(2020, 6, 25)));

        poland.setPerson(person);
        poland.setCountry(c_poland);
        session.save(poland);

        session.getTransaction().commit();
        session.close();
//
        List<Visa> visas = travelService.amountOfVisaPerson(person);
        assertEquals(2, visas.size());
        System.out.println(visas.get(0));
        assertEquals(usa1, (visas.get(0)));
        assertEquals(2, travelService.amountOfVisaCountry("USA").size());

    }

    @Test
    public void testSaveBookings() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country("Ukraine");
        session.save(country);
        City lviv = new City("Lviv");
        lviv.setCountry(country);
        session.save(lviv);
        Hotel h2 = new Hotel("GrandHotel", 5, 1, "hotel");
        h2.setCity(lviv);
        session.save(h2);
        Person person = new Person("Lolik", "Zhukin", "FD23111", 30);
        session.save(person);
        Rooms r1 = new Rooms(1, BUSINESS, DOUBLE);
        r1.setHotel(h2);



//        Bookings book = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 05, 16)),
//                java.sql.Date.valueOf(LocalDate.of(2020, 06, 16)));
//        book.setHotel(h2);
//        //book.getRoom().add(r1);
//        book.setPerson(person);
//        r1.setBooking(book);

        session.save(r1);
//
//        Bookings book1 =new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 05, 16)),
//            java.sql.Date.valueOf(LocalDate.of(2020, 06, 16)), 1, BUSINESS,SINGLE, lviv);
//        book1.setPerson(person);
//        book1.setHotel(h2);
//        book1.setRoom(book1.getAddRoom(r1));
//        session.save(book1);
//        Bookings book2 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 20)),
//            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, lviv);
//        book2.setPerson(person);
//        book2.setHotel(h2);
//        book2.setRoom(book2.getAddRoom(r1));
//        session.save(book2);
        session.getTransaction().commit();
        session.close();

//        Bookings book = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 17)),
//            java.sql.Date.valueOf(LocalDate.of(2020, 06, 19)), 1, BUSINESS,SINGLE, lviv);
//       List<Rooms>roomsForBook =  bookingService.roomsByCriteria(book);
//       assertEquals(1, roomsForBook.size());
//       assertEquals(r1, roomsForBook.get(0));
    }

}
