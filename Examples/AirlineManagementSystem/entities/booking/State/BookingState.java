package Examples.AirlineManagementSystem.entities.booking.State;

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

    public abstract boolean validate();

    // Failed, Expired ---Reserve Seat With Timeout---> Pending
    public abstract boolean reserve();

    // Pending ----Reserve Seat Permanently----> Confirmed
    // Pending ----Release Seat ----> Failed
    public abstract boolean confirm(Payment payment);

    // Pending ----Release Seat-----> Cancelled
    // Confirmed ----Release Seat-----> Cancelled (trigger Refund flow)
    public abstract boolean cancel();
}
