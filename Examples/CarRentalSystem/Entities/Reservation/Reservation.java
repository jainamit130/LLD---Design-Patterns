package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.CarRentalSystem;
import Examples.CarRentalSystem.Entities.*;
import Examples.CarRentalSystem.Entities.Billing.Bill;
import Examples.CarRentalSystem.Entities.Vehicle.Vehicle;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Reservation {
    private final String reservationId;
    private final User user;
    private final Vehicle vehicle;
    private final Store store;
    private final Instant pickUpTime;
    private final Location pickUpLocation;
    private final List<Location> usageLocations;
    private final Instant dropTime;
    private final Location dropLocation;
    private final double designatedKm;
    private double riddenKm;
    private Notifier notifier;
    private ReservationState state;
    private Bill bill;

    public Reservation(String reservationId, User user, Vehicle vehicle, Store store, Instant pickUpTime, Location pickUpLocation, List<Location> usageLocations, Instant dropTime, Location dropLocation, double designatedKm) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.store = store;
        this.pickUpTime = pickUpTime;
        this.pickUpLocation = pickUpLocation;
        this.usageLocations = usageLocations;
        this.dropTime = dropTime;
        this.dropLocation = dropLocation;
        this.designatedKm = designatedKm;
        this.state = new PendingState(this);
    }

    public double getDesignatedKm() {
        return designatedKm;
    }

    public long getDuration() {
        return Duration.between(pickUpTime,dropTime).toHours();
    }

    private String getNotificationMessage() {
        return state.getNotificationMessage();
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setState(ReservationState state) {
        this.state = state;
        notifier.notifyUser(user,getNotificationMessage());
    }

    public Bill reserve() {
        // calculate bill using different strategies
        return new Bill();
    }

    public Reservation confirm() {
        if(CarRentalSystem.reserve(this)) state.reserve();
        return this;
    }

    public Reservation cancel() {
        if(CarRentalSystem.cancel(this)) state.cancel();
        return this;
    }
}
