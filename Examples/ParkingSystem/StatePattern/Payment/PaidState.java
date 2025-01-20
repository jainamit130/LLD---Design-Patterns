package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.Transaction;

public class PaidState extends TransactionState {

    public PaidState(Transaction transaction) {
        super(TransactionStatus.PAID, transaction);
    }

    @Override
    public void transact() {
        throw new IllegalStateException("Payment is already completed!");
    }
}
