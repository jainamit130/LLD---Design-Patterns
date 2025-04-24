package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.sql.SQLOutput;
import java.time.Instant;

public class Cancelled extends State {
    public Cancelled(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
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
        flight.setDepartureTime(Instant.now());
        flight.setFlightState(new Rescheduled(flight,notifier));
        flight.depart();
    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        flight.setFlightState(new Rescheduled(flight,notifier));
        flight.setDepartureTime(departureTime);
        System.out.println("Flight has been rescheduled to depart at "+departureTime.toString());
    }

    @Override
    public void divertFlight(Airport destination) {
        System.out.println("Flight is cancelled and hence cannot be diverted!");
    }

    @Override
    public void cancelFlight() {
        System.out.println("Flight is already cancelled!");
    }
}
