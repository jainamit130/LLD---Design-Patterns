package Examples.AirlineManagementSystem.entities.booking.State;

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
    public boolean validate() {
        System.out.println("Booking is already confirmed");
        return false;
    }

    @Override
    public boolean reserve() {
        System.out.println("Booking is already confirmed");
        return false;
    }

    @Override
    public boolean confirm(Payment payment) {
        System.out.println("Booking is already confirmed!");
        return false;
    }

    @Override
    public boolean cancel() {
        boolean isCancelSuccess = booking.processCancellation();
        if(isCancelSuccess) {
            String bookingCancellationSuccessMessage = "Booking : "+booking.toString()+ "is cancelled.";
            String refundMessage = "Appropriate refund has been initiated";
            booking.notifyBooker(bookingCancellationSuccessMessage+" "+refundMessage);
            booking.notifyAll(bookingCancellationSuccessMessage);
            booking.notifyAndSetBookingState(new Cancelled(booking));
        } else {
            System.out.println("Booking could not be cancelled. Please try again");
        }
        return isCancelSuccess;
    }
}
