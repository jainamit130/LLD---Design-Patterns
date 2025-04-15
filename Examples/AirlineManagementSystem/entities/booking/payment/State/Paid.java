package Examples.AirlineManagementSystem.entities.booking.payment.State;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.PaymentStatus;

public class Paid extends PaymentState {

    protected Paid(Payment payment) {
        super(payment, PaymentStatus.PAID);
    }

    @Override
    public void process() {
        System.out.println("Payment is already completed!");
    }

    @Override
    public void refund(double refundPercent) {
        payment.refundAmount(refundPercent);
    }
}
