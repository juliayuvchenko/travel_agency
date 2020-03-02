package com.softserve.service;

import com.softserve.entity.Bookings;
import com.softserve.entity.Rooms;
import java.util.List;

public interface BookingService {

    List<Rooms> roomsByCriteria(Bookings bookings);


}
