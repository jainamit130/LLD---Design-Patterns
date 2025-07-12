package Examples.CarRentalSystem.Entities;

import Examples.CarRentalSystem.CarRentalSystem;
import Examples.CarRentalSystem.Entities.Billing.Bill;
import Examples.CarRentalSystem.Entities.Billing.TimeBasedStrategy;
import Examples.CarRentalSystem.Entities.Payment.Payment;
import Examples.CarRentalSystem.Entities.Reservation.Reservation;
import Examples.CarRentalSystem.Entities.Vehicle.Filter;
import Examples.CarRentalSystem.Entities.Vehicle.Vehicle;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private final String username;
    private final String drivingLicense;
    // updates to reservation add and update (no removals)
    private final List<Reservation> reservations = new ArrayList<>();

    public User(String userId, String username, String drivingLicense) {
        this.userId = userId;
        this.username = username;
        this.drivingLicense = drivingLicense;
    }

    public String getUserId() {
        return userId;
    }

    public Reservation reserve(Vehicle vehicle, Instant pickupTime,List<Location> usageLocations,Instant dropTime,double designatedKm) {
        Reservation reservation = new Reservation("ReservationId",this,vehicle,vehicle.getStore(),pickupTime,vehicle.getCurrentLocation(),usageLocations,dropTime,vehicle.getDesignatedLocation(),designatedKm);
        reservations.add(reservation.reserve(new TimeBasedStrategy(reservation.getBill())));
        return reservations.getLast();
    }



    public boolean pay(Bill bill, Payment payment) {
        return bill.pay(payment);
    }

    public boolean cancel(Bill bill, Payment payment) {
        return bill.cancel(payment);
    }

    public boolean refund(Bill bill, Payment payment) {
        return bill.refund(payment);
    }

    public Reservation activate(Reservation reservation) {
        return reservation.activate();
    }

    public Reservation complete(Reservation reservation, Location location) {
        return reservation.complete(location);
    }

    public List<Vehicle> search(String city, List<Filter> filters) {
        return CarRentalSystem.search(city,filters);
    }
}
