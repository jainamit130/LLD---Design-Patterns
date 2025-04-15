package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public abstract class BookingState {
    protected final Booking booking;
    protected final BookingStatus bookingStatus;

    protected BookingState(Booking booking, BookingStatus bookingStatus) {
        this.booking = booking;
        this.bookingStatus = bookingStatus;
    }

    public abstract void notifyBooking();

    // Failed, Expired ---Reserve Seat With Timeout---> Pending
    public abstract Payment book();

    // Pending ----Reserve Seat Permanently----> Confirmed
    // Pending ----Release Seat ----> Failed
    public abstract void confirm(Payment payment);

    // Pending ----Release Seat-----> Cancelled
    // Confirmed ----Release Seat-----> Cancelled (trigger Refund flow)
    public abstract void cancel();
}
