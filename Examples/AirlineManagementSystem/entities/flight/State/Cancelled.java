package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Cancelled extends State {
    public Cancelled(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
    }

    @Override
    public void scheduleFlight(Instant departureTime) {

    }

    @Override
    public void divertFlight(Airport airport) {

    }
}
