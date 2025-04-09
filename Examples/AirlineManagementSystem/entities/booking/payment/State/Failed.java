package Examples.AirlineManagementSystem.entities.booking.payment.State;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.PaymentStatus;

public class Failed extends PaymentState {

    protected Failed(Payment payment) {
        super(payment, PaymentStatus.FAILED);
    }

    @Override
    public void process() {
        boolean isPaymentSuccess = payment.pay();
        if(isPaymentSuccess) payment.setPaymentState(new Paid(payment));
        else payment.setPaymentState(new Failed(payment));
    }
}
