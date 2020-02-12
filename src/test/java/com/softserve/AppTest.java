package com.softserve;

import com.softserve.entity.City;
import com.softserve.entity.Country;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


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
    public void testSaveOperation()
    {
        System.out.println( "testSaveOperation begins ........ This is \"C\" of CRUD" );

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = new Country( "Ukraine");
        Country country2 = new Country( "USA" );
        session.save( country );
        session.save( country2 );


        City lviv = new City("Lviv");
        lviv.setCountry(country);
        session.save(lviv);

        City sanFrancisco = new City("San Francisco");
        sanFrancisco.setCountry(country2);
        session.save(sanFrancisco);


        session.getTransaction().commit();
        session.close();
        System.out.println( "testSaveOperation ends ......." );

    }

}
