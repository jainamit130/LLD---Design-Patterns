package Examples.CarRentalSystem.Entities.Billing;

public class TimeBasedStrategy extends BillingStrategy {

    public TimeBasedStrategy(Bill bill) {
        super(bill);
    }

    @Override
    public void populateBalance() {
        bill.setBalance(bill.getDuration()*12);
    }
}
