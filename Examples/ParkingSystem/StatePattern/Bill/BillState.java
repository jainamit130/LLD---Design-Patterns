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
        Integer netBalance = bill.getNetBalance();
        if(netBalance==0) {
            return new PaidState(bill);
        } else if (netBalance>0) {
            return new OverpaidState(bill);
        } else {
            if(bill.getOriginalAmount()>bill.getRefundedAmount()) return new PartiallyPaidState(bill);
            if(bill.getOriginalAmount()<bill.getRefundedAmount()) return new CompensatedState(bill);
            if(bill.getOriginalAmount().equals(bill.getRefundedAmount())) return new RefundedState(bill);
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
            bill.setBillState(getAppropriateState());
            bill.pay(payment);
        }
    }

    public void refund(RefundPayment refundPayment) {
        if(refundPayment.transact()) {
            bill.setBillState(getAppropriateState());
            bill.refund(refundPayment);
        }
    }
}
