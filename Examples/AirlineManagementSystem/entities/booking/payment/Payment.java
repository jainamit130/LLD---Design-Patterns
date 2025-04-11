package Examples.AirlineManagementSystem.entities.booking.payment;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.State.PaymentState;
import Examples.AirlineManagementSystem.entities.booking.payment.State.Pending;
import Examples.AirlineManagementSystem.service.payment.PaymentStrategy;

public class Payment {
    private final Booking booking;
    private PaymentStrategy paymentStrategy;
    private PaymentState paymentState;
    private final double amount;

    public Payment(Booking booking, double amount) {
        this.booking = booking;
        this.paymentState = new Pending(this);
        this.amount = amount;
    }

    public void process() {
        paymentState.process();
    }

    public boolean pay() {
        boolean isPaymentSuccess = paymentStrategy.processPayment(this);
        if(isPaymentSuccess) booking.notifyBookingSuccess();
        else booking.notifyBookingFailure();
        return isPaymentSuccess;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }
}
