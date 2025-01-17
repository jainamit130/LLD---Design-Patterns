package Examples.ParkingSystem.PaymentStrategies;

public interface PaymentStrategy {
    boolean validatePaymentDetails();
    void transact(Integer amount);
}
