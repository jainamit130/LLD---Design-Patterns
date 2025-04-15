package Examples.AirlineManagementSystem.entities.booking.payment.State;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.PaymentStatus;

public class Pending extends PaymentState {
    public Pending(Payment payment) {
        super(payment, PaymentStatus.PENDING);
    }

    @Override
    public void process() {
        boolean isPaymentSuccess = payment.pay();
        if(isPaymentSuccess) payment.setPaymentState(new Paid(payment));
        else payment.setPaymentState(new Failed(payment));
    }

    @Override
    public void refund(double refundPercent) {
        System.out.println("Payment is in pending state and hence cannot be refunded!");
    }
}
