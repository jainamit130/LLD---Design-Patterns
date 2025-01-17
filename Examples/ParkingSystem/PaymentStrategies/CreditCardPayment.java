package Examples.ParkingSystem.PaymentStrategies;

public class CreditCardPayment implements PaymentStrategy {
    private PaymentDetails details;

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(Integer amount) {

    }
}
