package Examples.CarRentalSystem.Entities.Billing;

import Examples.CarRentalSystem.Entities.Payment;
import Examples.CarRentalSystem.Entities.Reservation.Reservation;

import java.util.List;

public class Bill {
    private final String billId;
    private List<Payment> payment;
    private final BillingStrategy billingStrategy;
    private final Reservation reservation;
    private double balance;

    public Bill(String billId, BillingStrategy billingStrategy, Reservation reservation) {
        this.billId = billId;
        this.billingStrategy = billingStrategy;
        this.reservation = reservation;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private synchronized void pay(double amount) {
        balance += amount;
    }

    private synchronized double getBalance() {
        return balance;
    }

    public void pay(Payment payment) {
        payment.pay();
    }

    public double getDesignatedDistance() {
        return reservation.getDesignatedKm();
    }

    private long getDuration() {
        return reservation.getDuration();
    }
}
