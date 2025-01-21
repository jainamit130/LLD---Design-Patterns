package Examples.ParkingSystem.PaymentStrategies;

public interface TransactionStrategy {
    boolean validatePaymentDetails();
    boolean transact(Double amount);
}
