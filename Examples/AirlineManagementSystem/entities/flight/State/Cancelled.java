package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Cancelled extends State {
    public Cancelled(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.CANCELLED, notifier);
    }

    @Override
    public boolean validateBooking() {
        System.out.println("Flight has been cancelled! And no longer accept bookings!");
        return false;
    }

    @Override
    public double getRefundPercent() {
        System.out.println("A refund has already been initiated for the cancelled flight!");
        return 0.0;
    }

    @Override
    public void departFlight() {
        System.out.println("A Cancelled flight cannot depart!");
    }

    @Override
    public void landFlight() {
        System.out.println("A Cancelled flight cannot land!");
    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        System.out.println("Cannot schedule a cancelled flight!");
    }

    @Override
    public void cancelFlight() {
        System.out.println("Flight is already cancelled!");
    }
}
