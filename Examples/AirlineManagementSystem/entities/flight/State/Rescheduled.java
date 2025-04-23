package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Rescheduled extends State {
    public Rescheduled(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
    }

    @Override
    public double getRefundAmount(Booking booking) {
        return 0;
    }

    @Override
    public void departFlight() {

    }

    @Override
    public void scheduleFlight(Instant departureTime) {

    }

    @Override
    public void divertFlight(Airport airport) {

    }

    @Override
    public void cancelFlight() {

    }
}
