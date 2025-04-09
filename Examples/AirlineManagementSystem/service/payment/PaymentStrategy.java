package Examples.AirlineManagementSystem.service.payment;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;

public interface PaymentStrategy {
    boolean processPayment(Payment payment);
}
