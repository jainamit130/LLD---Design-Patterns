package Examples.AirlineManagementSystem.filter;

import Examples.AirlineManagementSystem.entities.flight.State.Flight;

@FunctionalInterface
public interface Filter {
    boolean apply(Flight flight);
}
