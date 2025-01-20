package Examples.ParkingSystem;

import Examples.ParkingSystem.PaymentStrategies.TransactionStrategy;
import Examples.ParkingSystem.StatePattern.Bill.Bill;
import Examples.ParkingSystem.StatePattern.Payment.TransactionState;
import Examples.ParkingSystem.StatePattern.Payment.PendingState;

public abstract class Transaction {
    protected TransactionStrategy transactionStrategy;
    protected Integer amount;
    protected TransactionState state;
    private Bill bill;

    public Transaction(TransactionStrategy transactionStrategy, Integer amount) {
        this.transactionStrategy = transactionStrategy;
        this.amount = amount;
        this.state = new PendingState(this);
        bill.addTransaction(this);
    }

    public void setPaymentState(TransactionState state) {
        this.state = state;
    }

    public TransactionState getState() {
        return state;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean transact() {
        if(!transactionStrategy.validatePaymentDetails()) {
            System.out.println("Invalid Transaction Details!");
            return false;
        }
        if(transactionStrategy.transact(amount)) return true;
        return false;
    }

    public abstract TransactionState getCompleteTransactionState();
}
