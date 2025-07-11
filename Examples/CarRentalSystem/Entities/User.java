package Examples.CarRentalSystem.Entities;

import Examples.CarRentalSystem.Entities.Billing.Bill;
import Examples.CarRentalSystem.Entities.Billing.TimeBasedStrategy;
import Examples.CarRentalSystem.Entities.Payment.Payment;
import Examples.CarRentalSystem.Entities.Reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private final String username;
    private final String drivingLicense;
    // updates to reservation add and update (no removals)
    private final List<Reservation> previousReservations = new ArrayList<>();

    public User(String userId, String username, String drivingLicense) {
        this.userId = userId;
        this.username = username;
        this.drivingLicense = drivingLicense;
    }

    public String getUserId() {
        return userId;
    }

    public Bill reserve(Reservation reservation) {
        return reservation.reserve(new TimeBasedStrategy(reservation.getBill()));
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

    public Reservation complete(Reservation reservation) {
        return reservation.complete();
    }
}
