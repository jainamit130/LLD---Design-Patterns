package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.PaymentStrategies.TransactionStrategy;
import Examples.ParkingSystem.Transaction;

public class Payment extends Transaction {
    public Payment(TransactionStrategy transactionStrategy, Integer amount) {
        super(transactionStrategy, amount);
    }

    @Override
    public TransactionState getCompleteTransactionState() {
        return new PaidState(this);
    }


}
