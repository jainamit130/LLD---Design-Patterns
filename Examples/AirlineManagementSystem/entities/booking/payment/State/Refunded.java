package Examples.AirlineManagementSystem.entities.booking.payment.State;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.PaymentStatus;

public class Refunded extends PaymentState {
    protected Refunded(Payment payment) {
        super(payment, PaymentStatus.REFUNDED);
    }

    @Override
    public void process() {
        System.out.println("Payment has already been refunded!");
    }

    @Override
    public void refund(double refundPercent) {
        payment.refundAmount(refundPercent);
    }
}
