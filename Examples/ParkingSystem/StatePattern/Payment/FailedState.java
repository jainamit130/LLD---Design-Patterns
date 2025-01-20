package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;

public class FailedState extends TransactionState {

    public FailedState(Transaction transaction) {
        super(TransactionStatus.FAILED, transaction);
    }

    @Override
    public void transact() {
        retry();
    }

    public void retry() {
        if(transaction.transact()) {
            transaction.setPaymentState(transaction.getCompleteTransactionState());
        } else {
            transaction.setPaymentState(new FailedState(transaction));
        }
    }
}
