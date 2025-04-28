package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.AirlineManagementSystem;
import Examples.AirlineManagementSystem.CrewAvailabilitySystem.AvailabilityManagement;
import Examples.AirlineManagementSystem.BookingManagement;
import Examples.AirlineManagementSystem.entities.flight.State.Flight;

import java.time.Instant;

public class Staff extends RegisteredUser {

    private final AirlineManagementSystem airlineManagementSystem;
    private final BookingManagement bookingManagement;
    private final AvailabilityManagement availabilityManagement;

    public Staff() {
        this.airlineManagementSystem = AirlineManagementSystem.getInstance();
        this.bookingManagement = BookingManagement.getInstance();
        this.availabilityManagement= AvailabilityManagement.getInstance();
    }

    public void cancelFlight(Flight flight) {
        bookingManagement.cancelFlight(flight);
    }

    public void rescheduleFlight(Flight flight, Instant departureTime) {
        flight.schedule(departureTime);
    }

    // Minimum to crew needed
    public boolean assignCrewToFlight(Flight flight) {
        while(flight.getCrews().size()<2) {
            if(!availabilityManagement.allocateCrewToFlight(flight) && !availabilityManagement.allocateAvailableCrew(flight)) break;
        }
        return flight.getCrews().size()>=2;
    }

}
