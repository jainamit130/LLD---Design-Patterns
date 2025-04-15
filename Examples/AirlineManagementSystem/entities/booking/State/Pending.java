package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Pending extends BookingState {

    public Pending(Booking booking) {
        super(booking, BookingStatus.PENDING);
    }

    @Override
    public void notifyBooking() {
        System.out.println("Booking is pending. No notification is needed");
    }

    @Override
    public Payment book() {
        Payment payment = booking.processBooking();
        if(payment==null) booking.notifyAndSetBookingState(new Failed(booking));
        else booking.notifyAndSetBookingState(new Reserved(booking));
        return payment;
    }

    @Override
    public void confirm(Payment payment) {
        boolean isPaymentSuccess = payment.pay();
        if(isPaymentSuccess) booking.notifyAndSetBookingState(new Confirmed(booking));
        else booking.notifyAndSetBookingState(new Failed(booking));
    }

    @Override
    public void cancel() {
        System.out.println("Booking was cancelled!");
        booking.notifyAndSetBookingState(new Cancelled(booking));
    }


}
