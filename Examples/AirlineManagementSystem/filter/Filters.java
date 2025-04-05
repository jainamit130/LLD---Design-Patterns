package Examples.AirlineManagementSystem.filter;

import Examples.AirlineManagementSystem.entities.Airport;

import java.time.LocalDate;
import java.time.ZoneId;

public class Filters {

    public static Filter bySource(Airport airport) {
        return flight -> flight.getSource().equals(airport);
    }

    public static Filter byDestination(Airport airport) {
        return flight -> flight.getDestination().equals(airport);
    }

    public static Filter byDate(LocalDate date) {
        return flight -> flight.getDepartureTime().atZone(ZoneId.of("UTC")).toLocalDate().equals(date);
    }
}
