package Examples.CarRentalSystem.Entities.Billing;

public abstract class BillingStrategy {
    protected Bill bill;
    public abstract void populateBalance();
}
