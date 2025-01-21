package Examples.ParkingSystem.PaymentStrategies;

public class CashTransaction implements TransactionStrategy {
    private PaymentDetails details;

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public boolean transact(Double amount) {
        // Do Processing to the external Payment System (Out of scope)
        System.out.println("Cash Transaction : Successfully transacted Rs. "+amount);
        return true;
    }
}
