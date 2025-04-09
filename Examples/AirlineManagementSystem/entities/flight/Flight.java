package Examples.AirlineManagementSystem.entities.flight;

import Examples.AirlineManagementSystem.entities.aircraft.Aircraft;
import Examples.AirlineManagementSystem.entities.flight.State.Scheduled;
import Examples.AirlineManagementSystem.entities.flight.State.State;
import Examples.AirlineManagementSystem.entities.user.Crew;
import Examples.AirlineManagementSystem.entities.user.Passenger;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private final String flightId;
    private final State flightState;
    private final Airport source;
    private final Airport destination;
    private final Aircraft aircraft;
    private final Instant departureTime;
    private final Instant arrivalTime;
    private final Duration duration;
    private final List<Passenger> passengers;
    private final List<Crew> crew;
    private final double price;

    public Flight(String flightId, Airport source, Airport destination, Aircraft aircraft, Instant departureTime, Duration duration, List<Crew> crew, Notifier notifier, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.duration = duration;
        this.price = price;
        this.arrivalTime = departureTime.plus(duration);
        this.flightState = new Scheduled(this,notifier);
        this.crew = crew;
        this.passengers = new ArrayList<>();
    }

    public Airport getSource() {
        return source;
    }

    public Airport getDestination() {
        return destination;
    }

    public Instant getDepartureTime() {
        return departureTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public State getFlightState() {
        return flightState;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
        this.arrivalTime = getDepartureTime().plus(duration);
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
        this.arrivalTime = getDepartureTime().plus(duration);
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setFlightState(State flightState) {
        this.flightState = flightState;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    public void schedule(Instant departureTime) {
        flightState.scheduleFlight(departureTime);
    }
}
