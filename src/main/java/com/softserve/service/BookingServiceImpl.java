package com.softserve.service;


import com.softserve.entity.Bookings;
import com.softserve.entity.Rooms;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookingServiceImpl implements BookingService {

    private final SessionFactory sessionFactory;
    public static BookingService bookingService = new BookingServiceImpl();
    private final Bookings bookings = new Bookings();
    public BookingServiceImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    @Override
    public List<Rooms> roomsByCriteria(Bookings bookings) {
        try (Session session = sessionFactory.openSession()){
            String sql = "select rooms.id,rooms.bedrooms, rooms.luxury, rooms.room_number, rooms.id_hotel " +
                "from (((bookings join bookings_rooms on bookings.id=bookings_rooms.bookings_id)" +
                "join rooms on rooms.id=bookings_rooms.room_id)" +
                "join hotels on rooms.id_hotel=hotels.id) where rooms.luxury=:luxury and rooms.bedrooms=:bedrooms and hotels.id_city=:id_city";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Rooms.class);
            query.setParameter("luxury" , bookings.getLuxury().ordinal());
            query.setParameter("bedrooms", bookings.getBedrooms().ordinal());
            query.setParameter("id_city" , bookings.getCity().getId());
            List<Rooms> rooms =  query.list();
            return rooms;
        }

//        select * from (((bookings join bookings_rooms on bookings.id=bookings_rooms.bookings_id) " +
//        "join rooms on rooms.id=bookings_rooms.room_id) " +
//            "join hotels on rooms.id_hotel=hotels.id) where hotels.id=:id
        catch (Exception e){
            System.out.println("Failed roomsByCriteria" + bookings);
            throw e;
        }
    }



}
