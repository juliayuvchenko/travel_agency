package com.softserve.service;

import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import com.softserve.entity.Person;
import com.softserve.entity.Rooms;
import com.softserve.entity.Visa;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.softserve.entity.Rooms.Bedrooms.APARTMENT;
import static com.softserve.entity.Rooms.Bedrooms.DOUBLE;
import static com.softserve.entity.Rooms.Bedrooms.SINGLE;
import static com.softserve.entity.Rooms.Bedrooms.TRIPLE;
import static com.softserve.entity.Rooms.Luxury.BUSINESS;
import static com.softserve.entity.Rooms.Luxury.ECONOM;
import static com.softserve.entity.Rooms.Luxury.PREMIUM;
import static com.softserve.entity.Rooms.Luxury.STANDARD;
import static org.junit.Assert.assertEquals;

public class TravelServiceImpTest {
    private static TravelService travelService;
    private static SessionFactory sessionFactory = null;

    private static Country ukraine;
    private static Country usa;
    private static Country poland;
    private static Country germany;
    private static Country france;
    private static Country uk;
    private static Country australia;

    private static City lviv;
    private static City kyiv;
    private static City washington;
    private static City krakow;
    private static City berlin;
    private static City paris;
    private static City london;
    private static City sydney;

    private static Hotel h1;
    private static Hotel h2;
    private static Hotel h3;
    private static Hotel h4;
    private static Hotel h5;
    private static Hotel h6;
    private static Hotel h7;
    private static Hotel h8;

    private static Rooms r1;
    private static Rooms r2;
    private static Rooms r3;
    private static Rooms r4;
    private static Rooms r5;
    private static Rooms r6;
    private static Rooms r7;
    private static Rooms r8;

    private static Person person1 ;
    private static Person person2 ;
    private static Person person3 ;
    private static Person person4 ;
    private static Person person5 ;
    private static Person person6 ;
    private static Person person7 ;
    private static Person person8 ;
    private static Person person9 ;

    private static Visa visa1 ;
    private static Visa visa2 ;
    private static Visa visa3 ;
    private static Visa visa4 ;
    private static Visa visa5 ;
    private static Visa visa6 ;
    private static Visa visa7 ;
    private static Visa visa8 ;
    private static Visa visa9 ;

    private static Bookings book1;
    private static Bookings book2;
    private static Bookings book3;
    private static Bookings book4;
    private static Bookings book5;
    private static Bookings book6;
    private static Bookings book7;
    private static Bookings book8;
    private static Bookings book9;
    private static Bookings book10;
    private static Bookings book11;
    private static Bookings book12;
    private static Bookings book13;
    private static Bookings book14;
    private static Bookings book15;


    @BeforeClass
    public static void setUp() throws Exception {
        travelService = TravelServiceImp.travelService;
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

        ukraine = new Country("Ukraine");
        session.save(ukraine);
        usa = new Country("USA");
        session.save(usa);
        poland = new Country("Poland");
        session.save(poland);
        germany = new Country("Germany");
        session.save(germany);
        france = new Country("France");
        session.save(france);
        uk = new Country("UK");
        session.save(uk);
        australia = new Country("Australia");
        session.save(australia);

        lviv = new City("Lviv");
        lviv.setCountry(ukraine);
        session.save(lviv);
        kyiv = new City("Kyiv");
        kyiv.setCountry(ukraine);
        session.save(kyiv);
        washington = new City("Washington");
        washington.setCountry(usa);
        session.save(washington);
        krakow = new City("Krakow");
        krakow.setCountry(poland);
        session.save(krakow);
        berlin = new City("Berlin");
        berlin.setCountry(germany);
        session.save(berlin);
        paris = new City("Paris");
        paris.setCountry(france);
        session.save(paris);
        london = new City("London");
        london.setCountry(uk);
        session.save(london);
        sydney = new City("Sydney");
        sydney.setCountry(australia);
        session.save(sydney);

        h1 = new Hotel("Hotel1", 2, 1, "hotel");
        h1.setCity(kyiv);
        session.save(h1);
        h2 = new Hotel("Hotel2", 3, 2, "hotel");
        h2.setCity(lviv);
        session.save(h2);
        h3 = new Hotel("Hotel3", 4, 3, "hotel");
        h3.setCity(washington);
        session.save(h3);
        h4 = new Hotel("Hotel4", 5, 4, "hotel");
        h4.setCity(krakow);
        session.save(h4);
        h5 = new Hotel("Hotel5", 4, 5, "hotel");
        h5.setCity(berlin);
        session.save(h5);
        h6 = new Hotel("Hotel6", 3, 4, "hotel");
        h6.setCity(paris);
        session.save(h6);
        h7 = new Hotel("Hotel7", 2, 3, "hotel");
        h7.setCity(london);
        session.save(h7);
        h8 = new Hotel("Hotel8", 5, 2, "hotel");
        h8.setCity(sydney);
        session.save(h8);

        r1 = new Rooms(1, ECONOM, SINGLE);
        r1.setHotel(h1);
        session.save(r1);
        r2 = new Rooms(2, STANDARD, DOUBLE);
        r2.setHotel(h2);
        session.save(r2);
        r3 = new Rooms(3, BUSINESS, TRIPLE);
        r3.setHotel(h3);
        session.save(r3);
        r4 = new Rooms(4, PREMIUM, APARTMENT);
        r4.setHotel(h4);
        session.save(r4);
        r5 = new Rooms(5, ECONOM, APARTMENT);
        r5.setHotel(h5);
        session.save(r5);
        r6 = new Rooms(6, STANDARD, TRIPLE);
        r6.setHotel(h6);
        session.save(r6);
        r7 = new Rooms(7, PREMIUM, APARTMENT);
        r7.setHotel(h7);
        session.save(r7);
        r8 = new Rooms(8, BUSINESS, SINGLE);
        r8.setHotel(h8);
        session.save(r8);

        person1 = new Person("Lolik", "Zhukin", "FD23111", 30);
        session.save(person1);
        person2 = new Person("Julia", "Maksimiv", "KT45231", 25);
        session.save(person2);
        person3 = new Person("Alex", "Rosa", "KL34112", 45);
        session.save(person3);
        person4 = new Person("Marta", "Zhukin", "PS65748", 30);
        session.save(person4);
        person5 = new Person("Orest", "West", "WE56479", 30);
        session.save(person5);
        person6 = new Person("Mark", "Alen", "LE59204", 30);
        session.save(person6);
        person7 = new Person("Kim", "Denwers", "CA35409", 30);
        session.save(person7);
        person8 = new Person("Emma", "Chester", "LP68304", 30);
        session.save(person8);
        person9 = new Person("Emily", "Brown", "BY58302", 30);
        session.save(person9);


        visa1 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa1.setCountry(ukraine);
        visa1.setPerson(person1);
        session.save(visa1);
        visa2 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa2.setCountry(usa);
        visa2.setPerson(person2);
        session.save(visa2);
        visa3 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa3.setCountry(poland);
        visa3.setPerson(person3);
        session.save(visa3);
        visa4 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa4.setCountry(germany);
        visa4.setPerson(person4);
        session.save(visa4);
        visa5 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa5.setCountry(france);
        visa5.setPerson(person5);
        session.save(visa5);
        visa6 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa6.setCountry(uk);
        visa6.setPerson(person6);
        session.save(visa6);
        visa7 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa7.setCountry(australia);
        visa7.setPerson(person7);
        session.save(visa7);
        visa8 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa8.setCountry(usa);
        visa8.setPerson(person8);
        session.save(visa8);
        visa9 = new Visa(java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 11)));
        visa9.setCountry(uk);
        visa9.setPerson(person9);
        session.save(visa9);

        book1 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 20)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, kyiv);
        book1.setPerson(person1);
        book1.setHotel(h1);
        book1.getRoom().add(r1);
        book1.setRoom(book1.getRoom());
        session.save(book1);
        book2 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 28)), 1, BUSINESS,SINGLE, lviv);
        book2.setPerson(person2);
        book2.setHotel(h2);
        book2.getRoom().add(r2);
        book2.setRoom(book2.getRoom());
        session.save(book2);
        book3 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 21)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, washington);
        book3.setPerson(person3);
        book3.setHotel(h3);
        book3.getRoom().add(r3);
        book3.setRoom(book3.getRoom());
        session.save(book3);
        book4 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 27)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 30)), 1, BUSINESS,SINGLE, krakow);
        book4.setPerson(person4);
        book4.setHotel(h4);
        book4.getRoom().add(r4);
        book4.setRoom(book4.getRoom());
        session.save(book4);
        book5 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 27)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 30)), 1, BUSINESS,SINGLE, berlin);
        book5.setPerson(person5);
        book5.setHotel(h5);
        book5.getRoom().add(r5);
        book5.setRoom(book5.getRoom());
        session.save(book5);
        book6 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 21)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, paris);
        book6.setPerson(person6);
        book6.setHotel(h6);
        book6.getRoom().add(r6);
        book6.setRoom(book6.getRoom());
        session.save(book6);
        book7 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 20)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, london);
        book7.setPerson(person7);
        book7.setHotel(h7);
        book7.getRoom().add(r7);
        book7.setRoom(book7.getRoom());
        session.save(book7);
        book8 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 20)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, sydney);
        book8.setPerson(person8);
        book8.setHotel(h8);
        book8.getRoom().add(r8);
        book8.setRoom(book8.getRoom());
        session.save(book8);
        book9 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 30)),
            java.sql.Date.valueOf(LocalDate.of(2020, 07, 04)), 1, BUSINESS,SINGLE, kyiv);
        book9.setPerson(person9);
        book9.setHotel(h1);
        book9.getRoom().add(r1);
        book9.setRoom(book9.getRoom());
        session.save(book9);
        book10 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 15)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 17)), 1, BUSINESS,SINGLE, lviv);
        book10.setPerson(person1);
        book10.setHotel(h2);
        book10.getRoom().add(r2);
        book10.setRoom(book10.getRoom());
        session.save(book10);
        book11 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 01)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 14)), 1, BUSINESS,SINGLE, washington);
        book11.setPerson(person2);
        book11.setHotel(h3);
        book11.getRoom().add(r3);
        book11.setRoom(book11.getRoom());
        session.save(book11);
        book12 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 05)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 10)), 1, BUSINESS,SINGLE, krakow);
        book12.setPerson(person3);
        book12.setHotel(h4);
        book12.getRoom().add(r4);
        book12.setRoom(book12.getRoom());
        session.save(book12);
        book13 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 15)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, berlin);
        book13.setPerson(person4);
        book13.setHotel(h5);
        book13.getRoom().add(r5);
        book13.setRoom(book13.getRoom());
        session.save(book13);
        book14 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 13)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 14)), 1, BUSINESS,SINGLE, paris);
        book14.setPerson(person1);
        book14.setHotel(h6);
        book14.getRoom().add(r6);
        book14.setRoom(book14.getRoom());
        session.save(book14);
        book15 = new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 10)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 14)), 1, BUSINESS,SINGLE, london);
        book15.setPerson(person6);
        book15.setHotel(h7);
        book15.getRoom().add(r7);
        book15.setRoom(book15.getRoom());
        session.save(book15);

        session.getTransaction().commit();
        session.close();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        sessionFactory.close();
    }

    @Test
    public void testFindHotelByCity() {
        System.out.println("testfindHotelByCity begins ........");

        assertEquals(1, travelService.findHotelByCity(lviv.getCity()).size());
        assertEquals(1, travelService.findHotelByCity(kyiv.getCity()).size());

        System.out.println("testfindHotelByCity ends ........");
    }

    @Test
    public void testFindCountry() {
        System.out.println("testfindCountry begins ........");
        assertEquals(7, travelService.findCountry().size());
        System.out.println("testfindCountry ends ........");
    }

    @Test
    public void testFindHotelByDate() {
        System.out.println("testFindHotelByDate begins ........");
        Bookings newBook= new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 15)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, lviv);
        newBook.setHotel(h2);
        assertEquals(true,travelService.findHotelByDate(newBook) );
        System.out.println("testFindHotelByDate ends ........");
    }

    @Test
    public void testFindAvailableHotel() {
        System.out.println("testFindAvailableHotel begins ........");
        Bookings newBook= new Bookings(java.sql.Date.valueOf(LocalDate.of(2020, 06, 15)),
            java.sql.Date.valueOf(LocalDate.of(2020, 06, 24)), 1, BUSINESS,SINGLE, lviv);
        assertEquals(1, travelService.findAvailableHotel(newBook).size());
        System.out.println("testFindAvailableHotel ends ........");
    }

    @Test
    public void testAmountOfVisaPerson() {
        System.out.println("testAmountOfVisaPerson begins ........");

        System.out.println("testAmountOfVisaPerson ends ........");
    }

    @Test
    public void testAmountOfVisaCountry() {
        System.out.println("testAmountOfVisaCountry begins ........");

        System.out.println("testAmountOfVisaCountry ends ........");
    }

    @Test
    public void testBookHotelForPerson() {
        System.out.println("testBookHotelForPerson begins ........");

        System.out.println("testBookHotelForPerson ends ........");
    }
}