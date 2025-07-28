package Examples.BookMyShow.model;

import Examples.BookMyShow.ReservationService;
import Examples.BookMyShow.model.Booking.Booking;
import Examples.BookMyShow.model.Reservation.Reservation;
import Examples.BookMyShow.model.Seat.Seat;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private final List<Booking> bookings;

    public User(String userId,String name) {
        this.userId = userId;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public Reservation reserve(Reservation reservation) {
        return reservation.reserve();
    }

    public Booking book(Reservation reservation) {
        Booking booking = reservation.book();
        if(booking!=null) bookings.add(booking);
        return booking;
    }

    public boolean cancelReservation(Reservation reservation) {
        return ReservationService.removeReservation(reservation);
    }

    public boolean cancel(Booking booking) {
        return booking.cancel();
    }
}


/*

User should be able to reserve tickets for 15 minutes and then confirm tickets
User should be able to cancel tickets during reservation and even after confirmation
User should be to see there upcoming and past bookings

*/