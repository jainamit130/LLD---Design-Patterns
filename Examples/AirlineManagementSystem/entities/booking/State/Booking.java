package Examples.AirlineManagementSystem.entities.booking.State;

import Examples.AirlineManagementSystem.AirlineManagementSystem;
import Examples.AirlineManagementSystem.BookingManagement;
import Examples.AirlineManagementSystem.entities.aircraft.Seat;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.flight.State.Flight;
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

    public boolean belongsTo(RegisteredUser user) {
        return this.user.equals(user);
    }

    public Payment getPayment() {
        return payment;
    }

    public String getBookingId() {return bookingId;}

    public double getRefundPercent() {
        return flight.getRefundPercent();
    }

    public double getRefundAmount() {
        return payment.refundAmount(flight.getRefundPercent());
    }

    public void lockFlightDuringPayment() {
        flight.readLock().lock();
    }

    public void unlockFlight() {
        flight.readLock().unlock();
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

    protected boolean validateBooking() {
        for (Seat seat: seats) {
            if(!flight.validateSeat(seat)) return false;
        }
        return (seats.size()==passengers.size() && flight.validateBooking());
    }

    protected boolean reserveSeats() {
        boolean isSeatsReservationSuccess = Seat.reserveSeats(seats);
        if(isSeatsReservationSuccess) System.out.println("Invalid Booking!");
        return isSeatsReservationSuccess;
    }

    protected void notifyBooker(String message) {
        System.out.println("Notification to : "+user.getName()+"about : "+message);
    }

    protected void notifyAll(String message) {
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

    protected boolean processCancellation() {
        return releaseBooking() && processCancellationRefund();
    }

    public boolean processCancellationRefund() {
        return AirlineManagementSystem.refundBooking(this);
    }

    protected Payment reserveBooking() {
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

    public void validate() { bookingState.validate(); }

    public void reserve() { bookingState.reserve(); }

    public void cancel() {
        bookingState.cancel();
    }

    public boolean releaseBooking() {
        bookingManagement.cancelBooking(this);
        return Seat.releaseSeats(seats);
    }

    @Override
    public String toString() {
        return "Booking {" + "bookingId = " + bookingId + "} ";
    }
}
