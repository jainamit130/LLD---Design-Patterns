package Examples.AirlineManagementSystem;

import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.entities.flight.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class BookingManagement {
    private static volatile BookingManagement instance;
    private Map<Flight, List<Booking>> flightBookings;
    private Map<String, ScheduledFuture<?>> reservedBookings;
    private final ScheduledExecutorService scheduler;

    private BookingManagement() {
        flightBookings = new ConcurrentHashMap<>();
        reservedBookings = new ConcurrentHashMap<>();
        scheduler = Executors.newScheduledThreadPool(10);
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

    public void cancelFlight(Flight cancelledFlight) {
        flightBookings.computeIfPresent(cancelledFlight,((flight,bookings) -> {
            bookings.stream().forEach(booking -> AirlineManagementSystem.refundBooking(booking));
            return null;
        }));
        flightBookings.remove(cancelledFlight);
    }

    public void cancelBooking(Booking booking) {
        releaseBooking(booking);
        flightBookings.compute(booking.getFlight(),((flight,bookings) -> {
            if(bookings!=null) bookings.remove(booking);
            return bookings;
        }));
    }

    public void reserveBooking(Booking booking) {
        ScheduledFuture<?> bookingScheduledFuture = scheduler.schedule(() -> {
            if(booking.expire()) System.out.println("Booking expired! Try again");
            else System.out.println("Error while expiring the booking!");
        }, 5, TimeUnit.MINUTES);
        reservedBookings.put(booking.getBookingId(),bookingScheduledFuture);
    }

    public void releaseBooking(Booking booking) {
        ScheduledFuture<?> bookingScheduledFuture = reservedBookings.remove(booking.getBookingId());
        if(bookingScheduledFuture!=null) bookingScheduledFuture.cancel(false);
    }

    public void confirmBooking(Booking booking) {
        releaseBooking(booking);
        flightBookings.compute(booking.getFlight(),((flight,bookings) -> {
            if(bookings==null) bookings = new ArrayList<>();
            bookings.add(booking);
            return bookings;
        }));
    }
}
