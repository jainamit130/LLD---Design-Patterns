package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Reserved extends BookingState {
    protected Reserved(Booking booking) {
        super(booking, BookingStatus.RESERVED);
    }

    @Override
    public void notifyBooking() {
        booking.notifyBooker("Booking is reserved! You have 5 minutes to complete booking.");
    }

    @Override
    public boolean validate() {
        System.out.println("Booking is already validated and reserved");
        return true;
    }

    @Override
    public boolean reserve() {
        System.out.println("Booking is already reserved! You have few minutes left!");
        return true;
    }

    @Override
    public boolean confirm(Payment payment) {
        boolean isPaymentSuccessful = payment.pay();
        if(isPaymentSuccessful) {
            booking.notifyAndSetBookingState(new Confirmed(booking));
        } else {
            System.out.println("Payment Failure caused booking failure");
            booking.notifyAndSetBookingState(new Failed(booking));
        }
        return isPaymentSuccessful;
    }

    @Override
    public boolean cancel() {
        boolean isBookingCancelled = booking.expire();
        if(isBookingCancelled) {
            booking.notifyAndSetBookingState(new Cancelled(booking));
        } else {
            System.out.println("Booking cancellation failed try again!");
        }
        return isBookingCancelled;
    }
}
