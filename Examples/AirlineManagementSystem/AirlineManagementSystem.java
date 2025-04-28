package Examples.AirlineManagementSystem;

import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.service.payment.CreditCardPayment;
import Examples.AirlineManagementSystem.service.payment.PaymentStrategy;

public class AirlineManagementSystem {
    private static volatile AirlineManagementSystem instance;
    public static double REFUND_PERCENT;
    private static PaymentStrategy PAYMENT_STRATEGY;

    private AirlineManagementSystem(double refundPercent,PaymentStrategy paymentStrategy) {
        REFUND_PERCENT = refundPercent;
        PAYMENT_STRATEGY = paymentStrategy;
    }

    public static AirlineManagementSystem getInstance() {
        AirlineManagementSystem airlineManagementSystem = instance;
        if(airlineManagementSystem==null) {
            synchronized(BookingManagement.class) {
                if(instance==null) {
                    instance = new AirlineManagementSystem(10,new CreditCardPayment());
                }
            }
        }
        return airlineManagementSystem;
    }

    public static boolean refundBooking(Booking booking) {
        Payment payment = new Payment(booking, booking.getRefundAmount());
        payment.setPaymentStrategy(PAYMENT_STRATEGY);
        return payment.pay();
    }
}
