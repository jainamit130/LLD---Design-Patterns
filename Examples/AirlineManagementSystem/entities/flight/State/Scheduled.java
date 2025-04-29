package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Scheduled extends State {
    public Scheduled(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.SCHEDULED, notifier);
    }

    @Override
    public boolean validateBooking() {
        return true;
    }

    @Override
    public double getRefundPercent() {
        return 0;
    }

    @Override
    public void departFlight() {
        if(!flight.validateFlight()) System.out.println("Flight validation failed!");
        processSchedule(Instant.now());
        flight.setFlightState(new InFlight(flight,notifier));
    }

    @Override
    public void landFlight() {
        System.out.println("Only a Flight in In-Flight status can land!");
    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        State newState = this;
        if(flight.getOriginalDepartureTime().isBefore(departureTime))
            newState = new Delayed(flight,notifier);
        flight.setFlightState(newState);
        flight.setDepartureTime(departureTime);
    }

    @Override
    public void cancelFlight() {
        flight.setFlightState(new Cancelled(flight,notifier));
    }
}
