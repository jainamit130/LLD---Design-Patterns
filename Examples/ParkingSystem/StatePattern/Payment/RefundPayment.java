package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;
import Examples.ParkingSystem.PaymentStrategies.TransactionStrategy;

public class RefundPayment extends Transaction {
    public RefundPayment(TransactionStrategy transactionStrategy, Integer amount) {
        super(transactionStrategy, amount);
    }

    @Override
    public TransactionState getCompleteTransactionState() {
        return new RefundedState(this);
    }
}
