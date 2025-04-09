package Examples.AirlineManagementSystem.entities.booking.payment.State;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.PaymentStatus;

public class Cancelled extends PaymentState {

    protected Cancelled(Payment payment) {
        super(payment, PaymentStatus.CANCELLED);
    }

    @Override
    public void process() {
        System.out.println("This payment was cancelled!");
    }
}
