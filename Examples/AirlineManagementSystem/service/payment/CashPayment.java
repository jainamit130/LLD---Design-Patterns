package Examples.AirlineManagementSystem.service.payment;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Initiating payment process by cash...");
        try {
            Thread.sleep(1000);
            return true;
        } catch (InterruptedException e) {
            System.out.println("Payment failed!");
        }
        return false;
    }
}
