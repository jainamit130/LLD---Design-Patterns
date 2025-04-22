package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Expired extends BookingState {
    protected Expired(Booking booking) {
        super(booking, BookingStatus.EXPIRED);
    }

    @Override
    public void notifyBooking() {
        booking.notifyBooker("Booking is expired!");
    }

    @Override
    public boolean validate() {
        booking.notifyAndSetBookingState(new Pending(booking));
        return booking.validateBooking();
    }

    @Override
    public boolean reserve() {
        return booking.validateBooking();
    }

    @Override
    public boolean confirm(Payment payment) {
        System.out.println("Booking has expired! Try booking again.");
        return false;
    }

    @Override
    public boolean cancel() {
        System.out.println("Booking has already expired!");
        return false;
    }
}
