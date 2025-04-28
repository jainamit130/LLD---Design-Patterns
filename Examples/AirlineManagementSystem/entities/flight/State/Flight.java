package Examples.AirlineManagementSystem.entities.flight.State;

import Examples.AirlineManagementSystem.entities.aircraft.Aircraft;
import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.user.Crew;
import Examples.AirlineManagementSystem.entities.user.Passenger;
import Examples.AirlineManagementSystem.notifier.Notifier;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Flight {
    private final ReentrantReadWriteLock lock;
    private Instant actualArrivalTime;
    private State flightState;
    private Airport source;
    private Airport destination;
    private Aircraft aircraft;
    private Instant departureTime;
    private final Instant originalDepartureTime;
    private final Airport originalSource;
    private final String flightId;
    private Instant arrivalTime;
    private Duration duration;
    private List<Passenger> passengers;
    private List<Crew> crews;
    private double price;

    public Flight(String flightId, Airport source, Airport destination, Aircraft aircraft, Instant departureTime, Duration duration, Notifier notifier, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.originalDepartureTime = departureTime;
        this.duration = duration;
        this.price = price;
        this.arrivalTime = departureTime.plus(duration);
        this.actualArrivalTime = null;
        this.flightState = new Scheduled(this,notifier);
        this.originalSource = source;
        this.crews = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public Airport getSource() {
        return source;
    }

    public Airport getDestination() {
        return destination;
    }

    public Instant getOriginalDepartureTime() {return originalDepartureTime;}

    public Airport getOriginalSource() {
        return originalSource;
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

    public List<Crew> getCrews() {
        return crews;
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
        this.arrivalTime = getDepartureTime().plus(duration);
    }

    public void setActualArrivalTime(Instant actualArrivalTime) {
        this.actualArrivalTime = actualArrivalTime;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
        this.arrivalTime = getDepartureTime().plus(duration);
    }

    public ReentrantReadWriteLock.ReadLock readLock() {
        return lock.readLock();
    }

    public ReentrantReadWriteLock.WriteLock writeLock() {
        return lock.writeLock();
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

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }

    public void schedule(Instant departureTime) {
        flightState.scheduleFlight(departureTime);
    }

    public double getRefundPercent() {
        return flightState.getRefundPercent();
    }

    public void depart() {
        flightState.departFlight();
    }

    public void cancel() {
        flightState.cancelFlight();
    }

    public boolean validateBooking() {
        return flightState.validateBooking();
    }

    public void arrive() {
        this.actualArrivalTime = Instant.now();
    }
}
