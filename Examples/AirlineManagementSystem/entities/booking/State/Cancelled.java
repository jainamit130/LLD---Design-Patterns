package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Cancelled extends BookingState {
    protected Cancelled(Booking booking) {
        super(booking, BookingStatus.CANCELLED);
    }

    @Override
    public void notifyBooking() {
        booking.notifyAll("Booking is cancelled");
    }

    @Override
    public boolean validate() {
        booking.notifyAndSetBookingState(new Pending(booking));
        return booking.validateBooking();
    }

    @Override
    public boolean reserve() {
        booking.notifyAndSetBookingState(new Pending(booking));
        return booking.validateBooking();
    }

    @Override
    public boolean confirm(Payment payment) {
        System.out.println("Booking is cancelled! Please create another booking");
        return false;
    }

    @Override
    public boolean cancel() {
        System.out.println("Booking is already cancelled!");
        return false;
    }
}
