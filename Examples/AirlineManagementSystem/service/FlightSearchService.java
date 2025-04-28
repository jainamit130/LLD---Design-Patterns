package Examples.AirlineManagementSystem.service;

import Examples.AirlineManagementSystem.entities.flight.State.Flight;
import Examples.AirlineManagementSystem.filter.FilterSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FlightSearchService {
    private Set<Flight> flights;

    public FlightSearchService(List<Flight> flights) {
        this.flights = new CopyOnWriteArraySet<>(flights);
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public List<Flight> searchFlights(FilterSystem filterSystem) {
        return filterSystem.filter(new ArrayList<>(flights));
    }
}
