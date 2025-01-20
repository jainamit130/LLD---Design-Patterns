package Examples.ParkingSystem.PaymentStrategies;

public class UPITransaction implements TransactionStrategy {
    private PaymentDetails details;

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public boolean transact(Integer amount) {
        // Do Processing to the external Payment System (Out of scope)
        System.out.println("Processing UPI Transaction...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("UPI Transaction failed!");
            e.printStackTrace();
        }
        System.out.println("UPI Transaction Successful : Successfully transacted Rs. "+amount);
        return true;
    }
}
