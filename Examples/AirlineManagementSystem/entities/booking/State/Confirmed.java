package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Confirmed extends BookingState {

    protected Confirmed(Booking booking) {
        super(booking, BookingStatus.CONFIRMED);
    }

    @Override
    public void notifyBooking() {
        booking.notifyAll("Booking is confirmed");
    }

    @Override
    public Payment book() {
        System.out.println("Booking is already confirmed");
        return null;
    }

    @Override
    public void confirm(Payment payment) {
        System.out.println("Booking is already confirmed!");
    }

    @Override
    public void cancel() {
        boolean isCancelSuccess = booking.processCancellation();

    }
}
