package Examples.ParkingSystem.StatePattern;

import Examples.ParkingSystem.Transaction;
import Examples.ParkingSystem.StatePattern.Payment.TransactionState;
import Examples.ParkingSystem.StatePattern.Payment.TransactionStatus;

public class PaidState extends TransactionState {

    public PaidState(Transaction transaction) {
        super(TransactionStatus.PAID, transaction);
    }
}
