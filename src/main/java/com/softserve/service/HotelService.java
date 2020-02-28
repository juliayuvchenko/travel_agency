package com.softserve.service;

import com.softserve.entity.City;
import com.softserve.entity.Hotel;
import java.util.List;

public interface HotelService {

    boolean availableHotel(Hotel hotel);
    List<Hotel> availableHotelInCity(City city);

}
