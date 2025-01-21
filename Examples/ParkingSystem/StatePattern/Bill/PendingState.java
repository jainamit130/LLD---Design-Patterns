package Examples.ParkingSystem.StatePattern.Bill;

public class PendingState extends BillState {
    public PendingState(Bill bill) {
        super(BillStatus.PENDING, bill);
    }

    public void markBillRefunded() {
        this.bill.setBillState(new RefundedState(bill));
    }
}
