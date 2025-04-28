package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Rescheduled extends State {
    public Rescheduled(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.RESCHEDULED, notifier);
    }

    @Override
    public boolean validateBooking() {
        return true;
    }

    @Override
    public double getRefundPercent() {
        return 30;
    }

    @Override
    public void departFlight() {
        flight.setFlightState(new InFlight(flight,notifier));
    }

    @Override
    public void landFlight() {
        System.out.println("Only a Flight in In-Flight status can land!");
    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        flight.setDepartureTime(departureTime);
        flight.setFlightState(new Rescheduled(flight,notifier));
    }

    @Override
    public void cancelFlight() {
        flight.setFlightState(new Cancelled(flight,notifier));
    }
}
