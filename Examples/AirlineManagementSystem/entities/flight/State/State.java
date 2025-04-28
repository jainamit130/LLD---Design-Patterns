package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.enums.FlightStatus;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Instant;

public abstract class State {
    protected final Flight flight;
    private final FlightStatus status;
    protected final Notifier notifier;

    protected State(Flight flight, FlightStatus status, Notifier notifier) {
        this.flight = flight;
        this.status = status;
        this.notifier = notifier;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void notifyPassengers() {
        notifier.notify(flight);
    }

    protected void processSchedule(Instant departureTime) {
        if(flight.getOriginalDepartureTime().isAfter(departureTime)) {
            flight.setFlightState(new Scheduled(flight,notifier));
        }
        flight.setDepartureTime(departureTime);
    }

    public final void schedule(Instant departureTime) {
        scheduleFlight(departureTime);
        notifyPassengers();
    }

    public abstract boolean validateBooking();
    public abstract double getRefundPercent();
    public abstract void departFlight();
    public abstract void landFlight();
    public abstract void scheduleFlight(Instant departureTime);
    public abstract void cancelFlight();
}
