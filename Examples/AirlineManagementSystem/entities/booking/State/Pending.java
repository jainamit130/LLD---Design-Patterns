package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Pending extends BookingState {

    public Pending(Booking booking) {
        super(booking, BookingStatus.PENDING);
    }

    // ->
    @Override
    public boolean confirm(Payment payment) {

    }

    @Override
    public boolean cancel() {

    }


}
