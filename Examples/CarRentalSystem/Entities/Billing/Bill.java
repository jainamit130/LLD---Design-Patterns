package Examples.CarRentalSystem.Entities.Billing;

import Examples.CarRentalSystem.Entities.Notifier;
import Examples.CarRentalSystem.Entities.Payment.Payment;
import Examples.CarRentalSystem.Entities.Reservation.Reservation;

import java.util.List;

public class Bill {
    private final String billId;
    private List<Payment> payments;
    private BillingStrategy billingStrategy;
    private final Reservation reservation;
    private double balance;

    public Bill(String billId, Reservation reservation) {
        this.billId = billId;
        this.reservation = reservation;
    }

    public void notify(String notification) {
        reservation.notify(notification);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void pay(double amount) {
        balance += amount;
    }

    public synchronized void refund(double amount) {
        balance -= amount;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public boolean pay(Payment payment) {
        boolean isSuccess = payment.pay();
        payments.add(payment);
        return isSuccess;
    }

    public boolean refund(Payment payment) {
        boolean isSuccess = payment.refund();
        payments.add(payment);
        return isSuccess;
    }

    public double getDesignatedDistance() {
        return reservation.getDesignatedKm();
    }

    public long getDuration() {
        return reservation.getDuration();
    }

    public boolean cancel(Payment payment) {
        boolean isSuccess = payment.cancel();
        payments.add(payment);
        return isSuccess;
    }
}
