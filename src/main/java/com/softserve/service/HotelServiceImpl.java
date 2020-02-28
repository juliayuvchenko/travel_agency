package com.softserve.service;

import com.softserve.entity.City;
import com.softserve.entity.Hotel;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HotelServiceImpl implements HotelService {
    private final SessionFactory sessionFactory;
    public static HotelService hotelService = new HotelServiceImpl();

    public HotelServiceImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }
    // if room is available = true
    //
    @Override
    public boolean availableHotel(Hotel hotel) {
//        List<Rooms> rooms = new ArrayList<Rooms>();
//        boolean isAvailable = false;
//        try (Session session = sessionFactory.openSession()){
//            String sql = "select * from rooms where id_hotel=:id";
//            SQLQuery query = session.createSQLQuery(sql);
//            query.addEntity(Rooms.class);
//            query.setParameter("id", hotel.getId());
//           rooms = query.list();
//
//        }
//        catch (Exception e){
//            System.out.println("Failed findAvailableHotel" );
//            throw e;
//        }
//
//        boolean[] available = new boolean[rooms.size()];
//        for( int i = 0; i< rooms.size(); i++){
//            Rooms room =  rooms.get(i);
//            available[i] =room.isAvailable();
//        }
//        for( int i =0; i<available.length; i++){
//            if(available[i] == true){
//                isAvailable = true;
//            }
//        }
//        return  isAvailable;
return true;
    }

    @Override
    public List<Hotel> availableHotelInCity(City city) {
        return null;
    }



}
