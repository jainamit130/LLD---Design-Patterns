package Examples.ParkingSystem.StatePattern.Bill;

public class CompensatedState extends BillState {
    public CompensatedState(Bill bill) {
        super(BillStatus.COMPENSATED, bill);
    }

}
