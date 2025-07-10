package Examples.CarRentalSystem.Entities.Billing;

public class TimeBasedStrategy extends BillingStrategy {

    @Override
    public void populateBalance() {
        bill.setBalance(bill.getDesignatedDistance()*12);
    }
}
