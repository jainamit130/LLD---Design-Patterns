package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Failed extends BookingState {
    protected Failed(Booking booking) {
        super(booking, BookingStatus.FAILED);
    }

    @Override
    public void notifyBooking() {
        booking.notifyBooker("Booking has failed!");
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
        System.out.println("Booking has failed! Try booking again.");
        return false;
    }

    @Override
    public boolean cancel() {
        System.out.println("Booking has already failed!");
        return false;
    }
}
