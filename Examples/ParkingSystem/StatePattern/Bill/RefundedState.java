package Examples.ParkingSystem.StatePattern.Bill;

public class RefundedState extends BillState {
    public RefundedState(Bill bill) {
        super(BillStatus.REFUNDED, bill);
    }
}
