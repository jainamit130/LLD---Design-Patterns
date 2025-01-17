package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;
import Examples.ParkingSystem.PaymentStrategies.PaymentStrategy;

public class RefundPayment extends Transaction {
    public RefundPayment(PaymentStrategy paymentStrategy, Integer amount) {
        super(paymentStrategy, amount);
    }
}
