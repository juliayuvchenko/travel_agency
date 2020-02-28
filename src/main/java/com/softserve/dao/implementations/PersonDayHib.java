package com.softserve.dao.implementations;

import com.softserve.dao.interfaces.PersonDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonDayHib implements PersonDao {
    private final SessionFactory sessionFactory;
    public static PersonDao personDao = new PersonDao();

    public PersonDayHib(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


}
