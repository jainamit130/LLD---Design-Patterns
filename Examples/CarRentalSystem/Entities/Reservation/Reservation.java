package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.CarRentalSystem;
import Examples.CarRentalSystem.Entities.*;
import Examples.CarRentalSystem.Entities.Billing.Bill;
import Examples.CarRentalSystem.Entities.Billing.BillingStrategy;
import Examples.CarRentalSystem.Entities.Payment.Payment;
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
        this.bill = new Bill(reservationId + "-bill",this);
        this.notifier = new Notifier();
    }

    public void updateDropLocation(Location location) {
        vehicle.updateCurrentLocation(location);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isReserved(Instant pickupTime, Instant dropTime) {
        return !(this.pickUpTime.isAfter(dropTime) || pickupTime.isAfter(this.dropTime));
    }

    public Bill getBill() {
        return bill;
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

    public void notify(String notification) {
        notifier.notifyUser(user,notification);
    }

    public void setState(ReservationState state) {
        this.state = state;
        notify(getNotificationMessage());
    }

    public Reservation reserve(BillingStrategy billingStrategy) {
        // calculate bill using different strategies
        billingStrategy.populateBalance();
        return this;
    }

    public Reservation confirm(Payment payment) {
        if(!bill.pay(payment)) return this;
        if(CarRentalSystem.reserve(this)) state.reserve();
        return this;
    }

    public Reservation cancel() {
        if(CarRentalSystem.remove(this)) state.cancel();
        return this;
    }

    public Reservation activate() {
        state.activate();
        return this;
    }

    public Reservation complete(Location location) {
        if(CarRentalSystem.remove(this)) {
            state.complete();
            updateDropLocation(location);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", state=" + state.toString() +
                '}';
    }
}
