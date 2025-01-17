package Examples.ParkingSystem.StatePattern.Payment;

public class RefundState extends TransactionState {
    public RefundState(RefundPayment payment) {
        super(TransactionStatus.REFUNDED, payment);
    }

    public void refund() {
        if(transaction.transact()) {
            transaction.setPaymentState(new RefundState((RefundPayment) transaction));
        } else {
            transaction.setPaymentState(new FailedState(transaction));
        }
    }
}
