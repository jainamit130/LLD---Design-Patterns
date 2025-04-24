package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class InFlight extends State {
    public InFlight(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
    }

    @Override
    public boolean validateBooking() {
        System.out.println("Flight is already in flight! And no longer is accepts booking.");
        return false;
    }

    @Override
    public double getRefundPercent() {
        return 0;
    }

    @Override
    public void departFlight() {

    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        System.out.println("Sorry unable to schedule a flight which has already arrived the destination!");
        return;
    }

    @Override
    public void divertFlight(Airport airport) {
        System.out.println("Sorry unable to divert a flight which has already arrived the destination!");
        return;
    }

    @Override
    public void cancelFlight() {

    }
}
