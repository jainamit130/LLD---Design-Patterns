package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Flight;
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
    public void divertFlight(Airport airport) {
        if(!flight.getDestination().equals(airport)) flight.setFlightState(new Diverted(flight,notifier));
        flight.setDestination(airport);
    }

    @Override
    public void cancelFlight() {

        flight.setFlightState(new Cancelled(flight,notifier));
    }
}
