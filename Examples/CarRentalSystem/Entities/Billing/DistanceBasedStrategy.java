package Examples.CarRentalSystem.Entities.Billing;

public class DistanceBasedStrategy extends BillingStrategy {

    public DistanceBasedStrategy(Bill bill) {
        super(bill);
    }

    @Override
    public void populateBalance() {
        bill.setBalance(bill.getDesignatedDistance()*60);
    }
}
