package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Delayed extends State {
    public Delayed(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
    }

    @Override
    public boolean validateBooking() {
        return true;
    }

    @Override
    public double getRefundPercent() {
        return 10.00;
    }

    @Override
    public void departFlight() {
        processSchedule(Instant.now());
        flight.setFlightState(new InFlight(flight,notifier));
    }

    @Override
    public void landFlight() {
        System.out.println("Only a Flight in In-Flight status can land!");
    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        processSchedule(departureTime);
    }

    @Override
    public void cancelFlight() {
        flight.setFlightState(new Cancelled(flight,notifier));
    }
}
