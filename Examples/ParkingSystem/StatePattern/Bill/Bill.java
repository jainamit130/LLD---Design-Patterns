package Examples.ParkingSystem.StatePattern.Bill;

import Examples.ParkingSystem.ParkingType;
import Examples.ParkingSystem.Pricing.PricingStrategy;
import Examples.ParkingSystem.Pricing.PricingStrategyFactory;
import Examples.ParkingSystem.StatePattern.Payment.Payment;
import Examples.ParkingSystem.StatePattern.Payment.RefundPayment;
import Examples.ParkingSystem.Transaction;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private String billId;
    private String tokenId;
    private PricingStrategy pricingStrategy;
    List<Transaction> transactions;
    private Double originalAmount;    // Original charge
    private Double paidAmount;        // Amount paid
    private Double refundedAmount;    // Amount refunded
    private BillState billState;

    public Bill(PricingStrategy pricingStrategy, Instant parkTime) {
        this.transactions = new ArrayList<>();
        this.pricingStrategy = pricingStrategy;
        this.originalAmount = pricingStrategy.calculatePrice(parkTime);
        this.paidAmount=0.0;
        this.refundedAmount=0.0;
        this.billState = new PendingState(this);
    }

    public BillState getBillState() { return billState; }

    public Double getOriginalAmount() {
        return originalAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public Double getRefundedAmount() {
        return refundedAmount;
    }

    public void setBillState(BillState state) {
        billState = state;
    }

    public Double getNetBalance() {
        return paidAmount-(originalAmount+refundedAmount);
    }

    /*
    * paidAmount-(originalAmount+refundedAmount)<0
    *
    *
    *
    * */

    private void payAmount(Double paidAmount) {
        this.paidAmount += paidAmount;
    }

    private void refundAmount(Double refundedAmount) {
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

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", pricingStrategy=" + pricingStrategy +
                ", transactions=" + transactions +
                ", originalAmount=" + originalAmount +
                ", paidAmount=" + paidAmount +
                ", refundedAmount=" + refundedAmount +
                ", billState=" + billState +
                '}';
    }
}
