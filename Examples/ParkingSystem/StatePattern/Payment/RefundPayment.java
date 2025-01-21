package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.StatePattern.Bill.Bill;
import Examples.ParkingSystem.Transaction;
import Examples.ParkingSystem.PaymentStrategies.TransactionStrategy;

public class RefundPayment extends Transaction {
    public RefundPayment(TransactionStrategy transactionStrategy, Double amount, Bill bill) {
        super(transactionStrategy, amount, bill);
    }

    @Override
    public TransactionState getCompleteTransactionState() {
        return new RefundedState(this);
    }

}
