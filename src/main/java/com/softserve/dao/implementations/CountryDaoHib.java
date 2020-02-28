package com.softserve.dao.implementations;

import com.softserve.dao.interfaces.CountryDao;
import com.softserve.entity.Country;
import com.softserve.entity.Hotel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

public class CountryDaoHib implements CountryDao {
    private final SessionFactory sessionFactory;
    public static CountryDao countryDao = new CountryDao();

    public CountryDaoHib() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }
    @Override
    public List<Country> findAll() {
        try(Session session = sessionFactory.openSession()){
            String sql = "SELECT * FROM countries";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Country.class);
            return query.list();
        }catch (Exception e){
            System.out.println("Failed findCountries");
            throw e;
        }
    }
    @Override
    public Optional<Country> findById(Country country){
        try(Session session = sessionFactory.openSession()){
            String sql = "SELECT * FROM countries WHERE id =:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Country.class);
            query.setParameter("id", country.getId());
        }catch (Exception e){
            System.out.println("Failed findCountriesById");
            throw e;
        }
    }
    @Override
    List<Country> findCountriesVisitedByPerson(Long personId){

    }



}
