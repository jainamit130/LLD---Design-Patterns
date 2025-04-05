package Examples.AirlineManagementSystem.entities;

import Examples.AirlineManagementSystem.entities.user.Passenger;

import java.util.List;

public class Booking {
    private String bookingId;
    private String userId;
    private String flightId;
    List<String> seatIds;
    List<Passenger> passengers;
}
