package Examples.ParkingSystem.StatePattern.Bill;

public class OverpaidState extends BillState {
    public OverpaidState(Bill bill) {
        super(BillStatus.OVERPAID, bill);
    }
}
