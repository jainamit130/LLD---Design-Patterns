package Examples.CarRentalSystem.Entities.Payment;

import Examples.CarRentalSystem.Entities.Billing.Bill;

public class Payment {
    private final Bill bill;
    private PaymentState state;
    private double amount;

    public Payment(Bill bill) {
        this.state = new Due(this);
        this.bill = bill;
    }

    public void setState(PaymentState state) {
        this.state = state;
        bill.notify("Payment is " + state.toString());
    }

    public Bill getBill() {
        return bill;
    }

    public boolean paying() {
        // do payment level validation
        bill.pay(amount);
        return true;
    }

    public boolean refunding() {
        // do payment level validation
        bill.refund(amount);
        return true;
    }

    public boolean cancelling() {
        // do payment level validation
        return true;
    }

    public boolean pay() {
        return state.pay();
    }

    public boolean cancel() {
        return state.cancel();
    }

    public boolean refund() {
        return state.refund();
    }
}
