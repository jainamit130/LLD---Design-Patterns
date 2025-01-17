package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.PaymentStrategies.PaymentStrategy;
import Examples.ParkingSystem.Transaction;

public class Payment extends Transaction {
    public Payment(PaymentStrategy paymentStrategy, Integer amount) {
        super(paymentStrategy, amount);
    }

}
