package Examples.ParkingSystem.StatePattern.Bill;

public class PaidState extends BillState {
    public PaidState(Bill bill) {
        super(BillStatus.PAID, bill);
    }
}
