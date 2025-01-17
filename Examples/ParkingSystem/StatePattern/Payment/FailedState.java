package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;
import Examples.ParkingSystem.StatePattern.PaidState;

public class FailedState extends TransactionState {

    public FailedState(Transaction transaction) {
        super(TransactionStatus.FAILED, transaction);
    }

    public void retry() {
        if(transaction.pay()) {
            transaction.setPaymentState(new PaidState(transaction));
        } else {
            transaction.setPaymentState(new FailedState(transaction));
        }
    }
}
