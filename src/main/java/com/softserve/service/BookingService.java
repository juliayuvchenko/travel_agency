package com.softserve.service;

import com.softserve.entity.Bookings;
import com.softserve.entity.City;
import com.softserve.entity.Hotel;
import com.softserve.entity.Rooms;
import java.util.List;

public interface BookingService {

    List<Rooms> roomsByCriteria(Bookings bookings);
    boolean isAvailableRoom(Bookings bookings, List<Rooms> roomsList);
    List<Hotel> hotelByCriteria(City city);

}
