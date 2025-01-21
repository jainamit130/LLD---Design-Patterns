package Examples.ParkingSystem.StatePattern.Payment;

import Examples.ParkingSystem.PaymentStrategies.TransactionStrategy;
import Examples.ParkingSystem.StatePattern.Bill.Bill;
import Examples.ParkingSystem.Transaction;

public class Payment extends Transaction {
    public Payment(TransactionStrategy transactionStrategy, Double amount, Bill bill) {
        super(transactionStrategy, amount, bill);
        this.state = new PendingState(this);
    }

    @Override
    public TransactionState getCompleteTransactionState() {
        return new PaidState(this);
    }


}
