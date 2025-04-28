package Examples.AirlineManagementSystem.service.Booking;

import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;

public class BookingService {

    private void validate(Booking booking) {
        booking.validate();
    }

     void reserve(Booking booking) {
        booking.reserve();
    }

    public void confirm(Booking booking, Payment payment) {
        booking.confirm(payment);
    }

    public void cancel(Booking booking) {
        booking.cancel();
    }

    public final Booking book(Booking booking) {
        validate(booking);
        reserve(booking);
        return booking;
    }

}
