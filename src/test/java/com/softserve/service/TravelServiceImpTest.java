package com.softserve.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TravelServiceImpTest {
    TravelService travelService;
    @BeforeClass
    public void setUp() throws Exception {
    travelService = TravelServiceImp.travelService;
    }

    @Test
    public void findHotelByCity() {

    }
}