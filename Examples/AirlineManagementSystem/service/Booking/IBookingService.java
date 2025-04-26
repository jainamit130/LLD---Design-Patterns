package Examples.AirlineManagementSystem.service.Booking;

import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.booking.State.Booking;

public interface IBookingService {
    boolean validate(Booking booking);

    boolean reserve(Booking booking);

    boolean confirm(Booking booking,Payment payment);

    boolean cancel(Booking booking);
}
