package Examples.AirlineManagementSystem;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.flight.Flight;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class BookingManagement {
    private static volatile BookingManagement instance;
    private Map<Flight, Set<Booking>> flightBookings;

    private BookingManagement() {
        flightBookings = new ConcurrentHashMap<>();
    }

    public static BookingManagement getInstance() {
        BookingManagement bookingManagement = instance;
        if(bookingManagement==null) {
            synchronized(BookingManagement.class) {
                if(instance==null) {
                    instance = new BookingManagement();
                }
            }
        }
        return bookingManagement;
    }

    public void updateBooking(Booking booking) {
        flightBookings.compute(booking.getFlight(),(((flight, bookingsSet) -> {
            if(bookingsSet==null) bookingsSet = new CopyOnWriteArraySet<>();
            bookingsSet.add(booking);
            return bookingsSet;
        })));
    }
}
