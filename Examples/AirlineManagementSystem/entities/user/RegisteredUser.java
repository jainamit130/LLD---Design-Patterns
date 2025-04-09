package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.service.BookingService;

public class RegisteredUser extends User {

    protected String name;
    protected Account account;

    // Should be able to book flights
    void bookFlight(BookingService bookingService, Booking booking) {

    }

    public String getName() {
        return name;
    }
}
