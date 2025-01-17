package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;
import Examples.ParkingSystem.StatePattern.PaidState;

public class PendingState extends TransactionState {

    public PendingState(Transaction transaction) {
        super(TransactionStatus.PENDING, transaction);
    }

    public void pay() {
        if(transaction.transact()) {
            transaction.setPaymentState(new PaidState(transaction));
        } else {
            transaction.setPaymentState(new FailedState(transaction));
        }
    }
}
