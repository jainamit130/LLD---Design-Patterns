package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Diverted extends State {
    public Diverted(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
    }

    @Override
    public void scheduleFlight(Instant departureTime) {

    }

    @Override
    public void divertFlight(Airport airport) {

    }
}
