package Examples.BookMyShow.model.Booking;

import Examples.BookMyShow.model.Reservation.Reservation;

public class Booking {
    private String bookingId;
    private Reservation reservation;
    private BookingStatus bookingStatus;

    public Booking(Reservation reservation) {
        this.reservation = reservation;
        this.bookingStatus = BookingStatus.BOOKED;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public boolean cancel() {
        if(reservation.cancel()) {
            setBookingStatus(BookingStatus.CANCELED);
            return true;
        }
        return false;
    }
}
