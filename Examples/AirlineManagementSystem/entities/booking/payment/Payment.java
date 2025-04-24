package Examples.AirlineManagementSystem.entities.booking.payment;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.State.PaymentState;
import Examples.AirlineManagementSystem.entities.booking.payment.State.Pending;
import Examples.AirlineManagementSystem.service.payment.PaymentStrategy;

public class Payment {
    private final Booking booking;
    private PaymentStrategy paymentStrategy;
    private PaymentState paymentState;
    private double amount;
    private double paidAmount;
    private double refundedAmount;

    public Payment(Booking booking, double amount) {
        this.booking = booking;
        this.paymentState = new Pending(this);
        this.amount = amount;
        this.paidAmount = 0;
        this.refundedAmount = 0;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void process() {
        paymentState.process();
    }

    public boolean pay() {
        return  paymentStrategy.processPayment(this);
    }

    public void payAmount(double amount) {
        this.paidAmount += amount;
    }

    public double refundAmount(double refundPercent) {
        return this.refundedAmount += (amount*refundPercent)/100.00;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }
}
