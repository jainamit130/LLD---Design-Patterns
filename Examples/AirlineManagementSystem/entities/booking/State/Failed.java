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
    public Payment book() {
        return null;
    }

    @Override
    public void confirm(Payment payment) {

    }

    @Override
    public void cancel() {

    }
}
