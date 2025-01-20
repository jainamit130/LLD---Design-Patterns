package Examples.ParkingSystem.PaymentStrategies;

public class CreditCardTransaction implements TransactionStrategy {
    private PaymentDetails details;

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public boolean transact(Integer amount) {
        // Do Processing to the external Payment System (Out of scope)
        System.out.println("Processing Credit Card Transaction...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Credit Card Transaction failed!");
            e.printStackTrace();
        }
        System.out.println("Credit Card Transaction Successful : Successfully transacted Rs. "+amount);
        return true;
    }
}
