package Examples.AirlineManagementSystem.entities.booking;

import Examples.AirlineManagementSystem.AirlineManagementSystem;
import Examples.AirlineManagementSystem.BookingManagement;
import Examples.AirlineManagementSystem.entities.aircraft.Seat;
import Examples.AirlineManagementSystem.entities.booking.State.BookingState;
import Examples.AirlineManagementSystem.entities.booking.State.Pending;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.entities.user.Passenger;
import Examples.AirlineManagementSystem.entities.user.RegisteredUser;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final RegisteredUser user;
    private final Flight flight;
    private BookingState bookingState;
    private Payment payment;
    private List<Seat> seats;
    private List<Passenger> passengers;
    private final BookingManagement bookingManagement;
    private final double refundPercent;

    public Booking(String bookingId, RegisteredUser user, Flight flight, List<Seat> seats, List<Passenger> passengers) {
        if(seats.size()==0 || passengers.size()==0) throw new RuntimeException("Invalid Booking!");
        this.bookingId = bookingId;
        this.user = user;
        this.flight = flight;
        this.seats = seats;
        this.passengers = passengers;
        this.bookingState = new Pending(this);
        this.payment = null;
        bookingManagement = BookingManagement.getInstance();
        this.refundPercent = AirlineManagementSystem.REFUND_PERCENT;
    }

    public String getBookingId() {return bookingId;}

    public double getRefundAmount() {
        return flight.getRefundAmount(this);
    }

    public Flight getFlight() {
        return flight;
    }

    private void setBookingState(BookingState state) {
        bookingState = state;
    }

    public void setPayment(Payment payment) { this.payment = payment; }

    private double calculatePrice() {
        double price = 0.0;
        for (Seat seat:seats) {
            price+=seat.getPrice();
        }
        return price;
    }

    public boolean validateBooking() {
        if(seats.size()!=passengers.size()) return false;
        boolean isSeatsReservationSuccess = Seat.reserveSeats(seats);
        if(isSeatsReservationSuccess) System.out.println("Invalid Booking!");
        return isSeatsReservationSuccess;
    }

    public void notifyBooker(String message) {
        System.out.println("Notification to : "+user.getName()+"about : "+message);
    }

    public void notifyAll(String message) {
        notifyBooker(message);
        for (Passenger passenger: passengers) {
            System.out.println("Notification to : "+passenger.getName()+"about : "+message);
        }
    }

    public boolean confirm(Payment payment) {
        boolean isBookingConfirmed = bookingState.confirm(payment);
        if(isBookingConfirmed) {
            bookingManagement.confirmBooking(this);
            Seat.bookSeats(seats);
        }
        return isBookingConfirmed;
    }

    public void cancel() {
        bookingState.cancel();
    }

    public boolean processCancellation() {
        return AirlineManagementSystem.refundBooking(this);
    }

    public Payment reserveBooking() {
        bookingManagement.reserveBooking(this);
        return new Payment(this, calculatePrice());
    }

    public void notifyAndSetBookingState(BookingState state) {
        setBookingState(state);
        state.notifyBooking();
    }

    public boolean expire() {
        bookingManagement.releaseBooking(this);
        return Seat.releaseSeats(seats);
    }
}
