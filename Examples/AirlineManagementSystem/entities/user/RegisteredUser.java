package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.service.Booking.BookingService;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;

public class RegisteredUser extends User {

    protected String name;
    protected Account account;

    // Should be able to book flights
    Booking bookFlight(BookingService bookingService, Booking booking) {
        return bookingService.book(booking);
    }

    Booking confirm(BookingService bookingService, Booking booking, Payment payment) {
        bookingService.confirm(booking,payment);
        return booking;
    }

    public String getName() {
        return name;
    }
}
