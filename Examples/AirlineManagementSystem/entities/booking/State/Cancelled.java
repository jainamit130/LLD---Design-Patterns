package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.entities.booking.Booking;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.enums.BookingStatus;

public class Cancelled extends BookingState {
    protected Cancelled(Booking booking) {
        super(booking, BookingStatus.CANCELLED);
    }

    @Override
    public void notifyBooking() {
        booking.notifyAll("Booking is cancelled");
    }

    @Override
    public Payment book() {
        System.out.println("Booking is cancelled! Please create another booking");
        return null;
    }

    @Override
    public void confirm(Payment payment) {
        System.out.println("Booking is cancelled! Please create another booking");
    }

    @Override
    public void cancel() {
        System.out.println("Booking is already cancelled!");
    }
}
