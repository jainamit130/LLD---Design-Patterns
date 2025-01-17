package Examples.ParkingSystem.StatePattern.Bill;

import Examples.ParkingSystem.Bill;
import Examples.ParkingSystem.StatePattern.BillStatus;

public abstract class BillState {
    protected BillStatus status;
    protected Bill bill;

    public BillState(BillStatus status, Bill bill) {
        this.status = status;
        this.bill = bill;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void pay() {

    }

    public void refund() {

    }
}
