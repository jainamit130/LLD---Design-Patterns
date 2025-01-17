package Examples.ParkingSystem;

import Examples.ParkingSystem.PaymentStrategies.PaymentStrategy;
import Examples.ParkingSystem.StatePattern.Payment.TransactionState;
import Examples.ParkingSystem.StatePattern.Payment.PendingState;

public abstract class Transaction {
    protected PaymentStrategy paymentStrategy;
    protected Integer amount;
    protected TransactionState state;

    public Transaction(PaymentStrategy paymentStrategy, Integer amount) {
        this.paymentStrategy = paymentStrategy;
        this.amount = amount;
        this.state = new PendingState(this);
    }

    public void setPaymentState(TransactionState state) {
        this.state = state;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean transact() {
        if(!paymentStrategy.validatePaymentDetails()) {
            System.out.println("Invalid Transaction Details!");
            return false;
        }
        paymentStrategy.transact(amount);
        return true;
    }
}
