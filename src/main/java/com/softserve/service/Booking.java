package com.softserve.service;

import com.softserve.entity.Bookings;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Booking implements Comparable<Booking> {

    private final static Comparator<Booking> asc;
    private final static Comparator<Booking> desc;

    static {
        asc = (o1, o2) -> {
            if (o1.start == o2.start && o1.end == o2.end) {
                return 0;
            }
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        };
        desc = asc.reversed();
    }

    private final int start;
    private final int end;

    public Booking(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static boolean checkAvailability(final List<Booking> bookings, final Booking newBooking) {
        final List<Booking> sortedBookings = bookings.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedBookings);


        final Optional<Booking> last = sortedBookings.stream().filter(b -> b.end >= newBooking.end).findFirst();
        final Optional<Booking> first = sortedBookings.stream().sorted(Booking.getDesc()).filter(f -> f.start <= newBooking.start).findFirst();

        System.out.println(String.format("first  %s", first));
        System.out.println(String.format("new  %s", newBooking));
        System.out.println(String.format("last %s", last));
        //empty bookings
        if (!first.isPresent() && !last.isPresent()) {
            return true;
        }

        //empty bookings
        if (first.isPresent()) {
            final Booking f = first.get();
            if (last.isPresent()) {
                final Booking l = last.get();
                if (f.end <= newBooking.start && newBooking.end <= l.start){
                    return true;
                }
            }

            if (f.end <= newBooking.start)
                return true;

            return false;
        }
        final Booking l = last.get();
        return newBooking.end <= l.start;
    }

    @Override
    public int compareTo(Booking o) {
        return asc.compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;

        Booking booking = (Booking) o;

        if (start != booking.start) return false;
        return end == booking.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
            "start=" + start +
            ", end=" + end +
            '}';
    }

    public static Comparator<Booking> getDesc() {
        return desc;
    }
}
