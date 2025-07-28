package Examples.BookMyShow.model.Reservation;

import Examples.BookMyShow.ReservationService;
import Examples.BookMyShow.model.Booking.Booking;
import Examples.BookMyShow.model.Seat.Seat;
import Examples.BookMyShow.model.Showing;

import java.util.List;

public class Reservation {
    private String reservationId;
    private List<Seat> seats;
    private Showing showing;
    private ReservationStatus status;

    public Reservation(String reservationId,List<Seat> seats) {
        this.reservationId=reservationId;
        this.seats = seats;
        this.status = ReservationStatus.RESERVED;
    }

    public String getReservationId() {
        return reservationId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public boolean cancel() {
        for(Seat seat:seats) {
            if(seat.cancel()) {
                setStatus(ReservationStatus.CANCELLED);
            } else {
                return false;
            }
        }
        return true;
    }

    public Booking book() {
        for(Seat seat:seats) {
            if (seat.book()) {
                setStatus(ReservationStatus.BOOKED);
            } else {
                // handle here to release all seats
                return null;
            }
        }
        return new Booking(this);
    }

    public boolean expire() {
        for (Seat seat : seats) {
            if (seat.expire()) {
                System.out.println(seat.getSeatId() + " expired");
                // if some sse connection then send a timeout event
            } else {
                // handle here to release all seats
                return false;
            }
        }
        return true;
    }

    public final boolean validate() {
        // if the event is happening in venue
        // if the show is valid
        // if the seats are part of the venue
        boolean validation = true;
        for(Seat seat:seats) validation |= seat.validate();
        validation |= showing.validate();
        return validation;
    }

    public Reservation reserve() {
        return ReservationService.reserve(this);
    }
}
