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
    public boolean validate() {
        if (!booking.validateBooking()) {
            System.out.println("Booking invalid!");
            booking.notifyAndSetBookingState(new Failed(booking));
        }
        return true;
    }

    @Override
    public boolean reserve() {
        booking.setPayment(booking.reserveBooking());
        booking.notifyAndSetBookingState(new Reserved(booking));
        return true;
    }

    @Override
    public boolean confirm(Payment payment) {
        boolean isPaymentSuccess = payment.pay();
        if(isPaymentSuccess) booking.notifyAndSetBookingState(new Confirmed(booking));
        else booking.notifyAndSetBookingState(new Failed(booking));
        return isPaymentSuccess;
    }

    @Override
    public boolean cancel() {
        System.out.println("Booking was cancelled!");
        booking.notifyAndSetBookingState(new Cancelled(booking));
        return true;
    }


}
