package com.softserve;

import com.softserve.entity.Country;
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
        Country country = new Country( 123, "Ukraine" );
        Country country2 = new Country( 1234, "USA" );

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save( country );
        session.save( country2 );

        session.getTransaction().commit();
        session.close();
        System.out.println( "testSaveOperation ends ......." );

    }

}
