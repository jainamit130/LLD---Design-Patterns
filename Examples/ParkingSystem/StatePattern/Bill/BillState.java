package Examples.ParkingSystem.StatePattern.Bill;

import Examples.ParkingSystem.StatePattern.Payment.Payment;
import Examples.ParkingSystem.StatePattern.Payment.RefundPayment;

public abstract class BillState {
    protected BillStatus status;
    protected Bill bill;

    public BillState(BillStatus status, Bill bill) {
        this.status = status;
        this.bill = bill;
    }

    public BillState getAppropriateState() {
        Double netBalance = bill.getNetBalance();
        if(netBalance==0) {
            return new PaidState(bill);
        } else if (netBalance>0) {
            return new OverpaidState(bill);
        } else {
            if(bill.getRefundedAmount().equals(bill.getPaidAmount())) return new PendingState(bill);
            if(bill.getOriginalAmount()>(bill.getPaidAmount()-bill.getRefundedAmount())) return new PartiallyPaidState(bill);
            if(bill.getOriginalAmount()<(bill.getRefundedAmount()-bill.getPaidAmount())) return new CompensatedState(bill);
        }
        return new PendingState(bill);
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

    public void pay(Payment payment) {
        if(payment.transact()) {
            bill.pay(payment);
            bill.setBillState(getAppropriateState());
        }
    }

    public void refund(RefundPayment refundPayment) {
        if(refundPayment.transact()) {
            bill.refund(refundPayment);
            bill.setBillState(getAppropriateState());
        }
    }
}
