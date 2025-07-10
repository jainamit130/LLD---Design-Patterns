package Examples.CarRentalSystem.Entities.Billing;

public class DistanceBasedStrategy extends BillingStrategy {

    @Override
    public void populateBalance() {
        bill.setBalance(bill.getDesignatedDistance()*60);
    }
}
