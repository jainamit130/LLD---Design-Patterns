package Examples.ParkingSystem.StatePattern.Bill;

import Examples.ParkingSystem.Bill;
import Examples.ParkingSystem.StatePattern.Payment.Payment;
import Examples.ParkingSystem.StatePattern.BillStatus;

public class PendingState extends BillState {

    public PendingState(Bill bill) {
        super(BillStatus.PENDING, bill);
    }

    public void pay(Payment payment) {
        if(payment.transact()) {
            
        }
    }

}
