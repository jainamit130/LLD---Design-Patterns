package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public class Arrived extends State {
    public Arrived(Flight flight, Notifier notifier) {
        super(flight, FlightStatus.DELAYED, notifier);
    }

    @Override
    public boolean validateBooking() {
        System.out.println("Flight has arrived! And no longer accept bookings!");
        return false;
    }

    @Override
    public double getRefundPercent() {
        System.out.println("Sorry unable to refund for a flight which has already arrived the destination!");
        return 0.0;
    }

    @Override
    public void departFlight() {
        System.out.println("Sorry unable to depart for the same flight which has already arrived!");
    }

    @Override
    public void scheduleFlight(Instant departureTime) {
        System.out.println("Sorry unable to schedule a flight which has already arrived the destination!");
        return;
    }

    @Override
    public void divertFlight(Airport airport) {
        if(!flight.getDestination().equals(airport)) flight.setFlightState(new Diverted(flight,notifier));
        flight.setDestination(airport);
    }

    @Override
    public void cancelFlight() {
        System.out.println("Cannot cancel a flight that has already arrived!");
    }
}
