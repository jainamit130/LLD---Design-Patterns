package Examples.ParkingSystem.StatePattern.Bill;

public class PartiallyPaidState extends BillState {
    public PartiallyPaidState(Bill bill) {
        super(BillStatus.PARTIALLY_PAID, bill);
    }
}
