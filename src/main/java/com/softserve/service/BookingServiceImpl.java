package com.softserve.service;


import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Hotel;
import com.softserve.entity.Rooms;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookingServiceImpl implements BookingService {

    private final SessionFactory sessionFactory;
    public static BookingService bookingService = new BookingServiceImpl();

    public BookingServiceImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }
    @Override
    public List<Hotel> hotelByCriteria(City city) {
//        try (Session session = sessionFactory.openSession()){
//            String sql = "select rooms.id,rooms.bedrooms, rooms.luxury, rooms.room_number, rooms.id_hotel " +
//                "from ((rooms inner join hotels on rooms.id_hotel = hotels.id) left join bookings on rooms.id = id_rooms)  " +
//                "where rooms.luxury=:luxury and rooms.bedrooms=:bedrooms and hotels.id_city=:id_city";
//            SQLQuery query = session.createSQLQuery(sql);
//            query.addEntity(Rooms.class);
//            query.setParameter("luxury" , bookings.getLuxury().ordinal());
//            query.setParameter("bedrooms", bookings.getBedrooms().ordinal());
//            query.setParameter("id_city" , bookings.getCity().getId());
//            List<Rooms> rooms =  query.list();
//            return rooms;
//        }
//        catch (Exception e){
//            System.out.println("Failed roomsByCriteria" + bookings);
//            throw e;
//        }
        return null;
    }
    @Override
    public List<Rooms> roomsByCriteria(Bookings bookings) {
        try (Session session = sessionFactory.openSession()){
            String sql = "select rooms.id,rooms.bedrooms, rooms.luxury, rooms.room_number, rooms.id_hotel " +
                "from ((rooms inner join hotels on rooms.id_hotel = hotels.id) left join bookings on rooms.id = id_rooms)  " +
                "where rooms.luxury=:luxury and rooms.bedrooms=:bedrooms and hotels.id_city=:id_city";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Rooms.class);
            query.setParameter("luxury" , bookings.getLuxury().ordinal());
            query.setParameter("bedrooms", bookings.getBedrooms().ordinal());
            query.setParameter("id_city" , bookings.getCity().getId());
            List<Rooms> rooms =  query.list();
            return rooms;
        }
        catch (Exception e){
            System.out.println("Failed roomsByCriteria" + bookings);
            throw e;
        }
    }

    @Override
    public boolean isAvailableRoom(Bookings bookings, List<Rooms> roomsList) {
        try (Session session = sessionFactory.openSession()){
            List<Rooms> rooms =  new ArrayList<>();
           for(int i=0; i<roomsList.size();i++){
               String sql = "select bookings.id, bookings.checkin, bookings.checkout, bookings.id_hotel, " +
                "bookings.id_person, bookings.bedrooms, bookings.luxury, bookings.quantity, bookings.id_city " +
                "from bookings left join bookings_rooms on bookings.id=bookings_rooms.bookings_id " +
                "where room_id=:room_id and bookings.checkout<=:checkin and bookings.checkin>=:checkout sort by checkin";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Bookings.class);
            query.setParameter("room_id" ,roomsList.get(i));
            query.setParameter("checkout", bookings.getCheckout());
            query.setParameter("checkin" , bookings.getCheckin());
           // checkAvailability(query.list(), bookings);
           }
            return true;
        }
        catch (Exception e){
            System.out.println("Failed isAvailable" + bookings);
            throw e;
        }
    }



//    public static boolean checkAvailability(final List<Bookings> bookings, final Bookings newBooking) {
//        final List<Bookings> sortedBookings = bookings.stream().sorted().collect(Collectors.toList());
//        System.out.println(sortedBookings);
//
//
//        final Optional<Booking> last = sortedBookings.stream().filter(b -> b.getCheckout() >= newBooking.getCheckout()).findFirst();
//        final Optional<Booking> first = sortedBookings.stream().sorted(Booking.getDesc()).filter(f -> f.start <= newBooking.start).findFirst();
//
//        System.out.println(String.format("first  %s", first));
//        System.out.println(String.format("new  %s", newBooking));
//        System.out.println(String.format("last %s", last));
//        //empty bookings
//        if (!first.isPresent() && !last.isPresent()) {
//            return true;
//        }
//
//        //empty bookings
//        if (first.isPresent()) {
//            final Booking f = first.get();
//            if (last.isPresent()) {
//                final Booking l = last.get();
//                if (f.end <= newBooking.start && newBooking.end <= l.start){
//                    return true;
//                }
//            }
//
//            if (f.end <= newBooking.start)
//                return true;
//
//            return false;
//        }
//        final Booking l = last.get();
//        return newBooking.end <= l.start;
//    }


}
