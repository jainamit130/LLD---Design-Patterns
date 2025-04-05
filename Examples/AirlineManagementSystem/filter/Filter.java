package Examples.AirlineManagementSystem.filter;

import Examples.AirlineManagementSystem.entities.flight.Flight;

@FunctionalInterface
public interface Filter {
    boolean apply(Flight flight);
}
