package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;

public class PendingState extends TransactionState {

    public PendingState(Transaction transaction) {
        super(TransactionStatus.PENDING, transaction);
    }

    @Override
    public void transact() {
        if(transaction.transact()) {
            transaction.setPaymentState(transaction.getCompleteTransactionState());
        } else {
            transaction.setPaymentState(new FailedState(transaction));
        }
    }
}
