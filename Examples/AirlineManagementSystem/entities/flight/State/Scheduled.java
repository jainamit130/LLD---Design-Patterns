package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Scheduled extends State {
    public Scheduled(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        State newState = this;
        if(flight.getDepartureTime().isBefore(departureTime))
            newState = new Delayed(flight,notifier);
        else newState = new Rescheduled(flight,notifier);
        flight.setFlightState(newState);
        flight.schedule(departureTime);
    }

    @Override
    public void divertFlight(Airport airport) {
        if(!flight.getDestination().equals(airport)) flight.setFlightState(new Diverted(flight,notifier));
        flight.setDestination(airport);
    }
}
