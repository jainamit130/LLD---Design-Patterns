package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public abstract class BookingState {
    protected final Booking booking;
    protected final BookingStatus bookingStatus;

    protected BookingState(Booking booking, BookingStatus bookingStatus) {
        this.booking = booking;
        this.bookingStatus = bookingStatus;
    }

    public abstract void book();
    public abstract void cancel();
}
