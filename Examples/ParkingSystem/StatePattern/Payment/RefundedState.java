package Examples.ParkingSystem.StatePattern.Payment;

public class RefundedState extends TransactionState {
    public RefundedState(RefundPayment payment) {
        super(TransactionStatus.REFUNDED, payment);
    }

    @Override
    public void transact() {
        throw new IllegalStateException("Refund Payment is already completed");
    }
}
