package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;

public abstract class TransactionState {
    protected TransactionStatus status;
    protected Transaction transaction;

    public TransactionState(TransactionStatus status, Transaction transaction) {
        this.status = status;
        this.transaction = transaction;
    }

    public abstract void transact();
}
