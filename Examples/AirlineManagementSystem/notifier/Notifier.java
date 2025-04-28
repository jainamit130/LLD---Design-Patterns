package Examples.AirlineManagementSystem.notifier;

import Examples.AirlineManagementSystem.entities.flight.State.Flight;

public class Notifier {

    public void notify(Flight flight) {
        flight.getPassengers().stream().forEach(passenger -> passenger.notifyPassenger(flight));
    }
}
