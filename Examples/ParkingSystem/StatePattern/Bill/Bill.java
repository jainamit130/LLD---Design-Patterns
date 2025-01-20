package Examples.ParkingSystem.StatePattern.Bill;

import Examples.ParkingSystem.StatePattern.Bill.BillState;
import Examples.ParkingSystem.StatePattern.Bill.BillStatus;
import Examples.ParkingSystem.StatePattern.Payment.Payment;
import Examples.ParkingSystem.StatePattern.Payment.RefundPayment;
import Examples.ParkingSystem.Transaction;

import java.util.List;

public class Bill {
    private String billId;
    private String tokenId;
    List<Transaction> transactions;
    private Integer originalAmount;    // Original charge
    private Integer paidAmount;        // Amount paid
    private Integer refundedAmount;    // Amount refunded
    private BillState billState;

    /*
    *
    *
    * if PaidAmount - RefundedAmount
    *
    *
    * */

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public void setBillState(BillState state) {
        billState = state;
    }

    public Integer getNetBalance() { return paidAmount-(originalAmount+refundedAmount); }

    private void payAmount(Integer paidAmount) {
        this.paidAmount += paidAmount;
    }

    private void refundAmount(Integer refundedAmount) {
        this.refundedAmount += refundedAmount;

    }

    public void pay(Payment payment) {
        payAmount(payment.getAmount());
    }

    public void refund(RefundPayment refundPayment) {
        refundAmount(refundPayment.getAmount());
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
