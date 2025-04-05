package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.entities.Booking;

public class RegisteredUser extends User {

    protected String name;
    protected Account account;

    // Should be able to book flights
    void bookFlight(Booking booking) {

    }
}
