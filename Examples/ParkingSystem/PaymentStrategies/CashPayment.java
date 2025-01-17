package Examples.ParkingSystem.PaymentStrategies;

public class CashPayment implements PaymentStrategy {
    private PaymentDetails details;

    @Override
    public boolean validatePaymentDetails() {
        return false;
    }

    @Override
    public void pay(Integer amount) {

    }
}
