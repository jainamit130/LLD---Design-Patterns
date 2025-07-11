package Examples.CarRentalSystem.Entities.Billing;

public abstract class BillingStrategy {
    protected final Bill bill;

    protected BillingStrategy(Bill bill) {
        this.bill = bill;
    }

    public abstract void populateBalance();
}
