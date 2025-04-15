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
