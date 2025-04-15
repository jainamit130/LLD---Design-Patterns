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
