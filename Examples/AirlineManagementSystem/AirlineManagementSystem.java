package Examples.AirlineManagementSystem;

import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.service.payment.PaymentStrategy;

public class AirlineManagementSystem {
    public static double REFUND_PERCENT;
    private static PaymentStrategy PAYMENT_STRATEGY;

    public AirlineManagementSystem(double refundPercent,PaymentStrategy paymentStrategy) {
        REFUND_PERCENT = refundPercent;
        PAYMENT_STRATEGY = paymentStrategy;
    }

    public static boolean refundBooking(Booking booking) {
        Payment payment = new Payment(booking, booking.getRefundAmount());
        payment.setPaymentStrategy(PAYMENT_STRATEGY);
        return payment.pay();
    }
}
