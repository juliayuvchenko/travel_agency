package com.softserve;

import com.softserve.service.Booking;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookingTest {


    @Test
    public void emptyDb() {
        final List<Booking> bookings = Collections.emptyList();
        assertTrue((Booking.checkAvailability(bookings, newBooking)));
    }

    @Test
    public void inBetween() {
        final List<Booking> bookings = Arrays.asList(
            new Booking(25, 28),
            new Booking(44, 48),
            new Booking(5, 8),
            new Booking(14, 20),
            new Booking(12, 20),
            new Booking(1, 5),
            new Booking(1, 3),
            new Booking(34, 38),
            new Booking(54, 58));

        assertTrue((Booking.checkAvailability(bookings, newBooking)));
    }

    @Test
    public void onlyBefore() {
        final List<Booking> bookings = Arrays.asList(
            new Booking(1, 3),
            new Booking(1, 5),
            new Booking(5, 8),
            new Booking(12, 20),
            new Booking(14, 20));

        assertTrue((Booking.checkAvailability(bookings, newBooking)));
    }


    @Test
    public void onlyAfter() {
        final List<Booking> bookings =Arrays.asList(
            new Booking(25, 28),
            new Booking(34, 38),
            new Booking(44, 48),
            new Booking(54, 58));

        assertTrue((Booking.checkAvailability(bookings, newBooking)));
    }

    @Test
    public void random1() {
        final List<Booking> bookings = Arrays.asList(
            new Booking(54, 58));

        assertTrue((Booking.checkAvailability(bookings, newBooking)));
    }

    @Test
    public void random2() {
        final List<Booking> bookings = Arrays.asList(
            new Booking(5, 8));

        assertTrue((Booking.checkAvailability(bookings, newBooking)));
    }

    @Test
    public void only1() {
        final List<Booking> bookings =Arrays.asList(
            new Booking(24, 28),
            new Booking(34, 38),
            new Booking(44, 48),
            new Booking(54, 58));

        assertFalse((Booking.checkAvailability(bookings, newBooking)));
    }
    private final Booking newBooking = new Booking(20, 25);

    @Test
    public void only2() {
        final List<Booking> bookings =Arrays.asList(
            new Booking(18, 21),
            new Booking(24, 38),
            new Booking(44, 48),
            new Booking(54, 58));

        assertFalse((Booking.checkAvailability(bookings, newBooking)));
    }
}
