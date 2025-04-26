package Examples.AirlineManagementSystem.service.Booking;

import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;

public class BookingService implements IBookingService {

    @Override
    public boolean validate(Booking booking) {
        return booking.validate();
    }

    @Override
    public boolean reserve(Booking booking) {
        return false;
    }

    @Override
    public boolean confirm(Booking booking, Payment payment) {
        return false;
    }

    @Override
    public boolean cancel(Booking booking) {
        return false;
    }
}
