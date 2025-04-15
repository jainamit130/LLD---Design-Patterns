package Examples.AirlineManagementSystem.entities.booking.payment.State;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.PaymentStatus;

public abstract class PaymentState {
    protected final Payment payment;
    protected final PaymentStatus paymentStatus;

    protected PaymentState(Payment payment, PaymentStatus paymentStatus) {
        this.payment = payment;
        this.paymentStatus = paymentStatus;
    }

    public abstract void process();
    public abstract void refund(double refundPercent);
}
