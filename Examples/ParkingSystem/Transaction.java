package Examples.ParkingSystem;

import Examples.ParkingSystem.PaymentStrategies.TransactionStrategy;
import Examples.ParkingSystem.StatePattern.Bill.Bill;
import Examples.ParkingSystem.StatePattern.Payment.TransactionState;
import Examples.ParkingSystem.StatePattern.Payment.PendingState;

public abstract class Transaction {
    protected TransactionStrategy transactionStrategy;
    protected Double amount;
    protected TransactionState state;
    private Bill bill;

    public Transaction(TransactionStrategy transactionStrategy, Double amount,Bill bill) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionStrategy=" + transactionStrategy +
                ", amount=" + amount +
                ", state=" + state +
                ", bill=" + bill +
                '}';
    }
}
