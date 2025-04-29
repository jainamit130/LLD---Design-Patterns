package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.entities.flight.State.Flight;
import Examples.AirlineManagementSystem.filter.FilterSystem;
import Examples.AirlineManagementSystem.service.FlightSearchService;

import java.util.List;

public abstract class User {
    protected String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public List<Flight> searchFlights(FlightSearchService flightSearchService, FilterSystem filterSystem) {
        return flightSearchService.searchFlights(filterSystem);
    }
}
