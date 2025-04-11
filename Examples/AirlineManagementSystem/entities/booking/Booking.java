package Examples.AirlineManagementSystem.entities.booking;

import Examples.AirlineManagementSystem.BookingManagement;
import Examples.AirlineManagementSystem.entities.aircraft.Seat;
import Examples.AirlineManagementSystem.entities.booking.State.BookingState;
import Examples.AirlineManagementSystem.entities.booking.State.Pending;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.flight.Flight;
import Examples.AirlineManagementSystem.entities.user.Passenger;
import Examples.AirlineManagementSystem.entities.user.RegisteredUser;

import java.util.List;
import java.util.concurrent.Delayed;

public class Booking implements Delayed {
    private final String bookingId;
    private final RegisteredUser user;
    private final Flight flight;
    private final BookingState bookingState;
    private Payment payment;
    private List<Seat> seats;
    private List<Passenger> passengers;
    private final BookingManagement bookingManagement;
    private final long timeout;

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
        this.timeout = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(300000);
    }

    public Flight getFlight() {
        return flight;
    }

    public void notifyBookingFailure() {
        System.out.println("Notification to : "+user.getName()+"about booking failure");
    }

    public void notifyBookingSuccess() {

        System.out.println("Notification to : "+user.getName()+"about booking successful");
        for (Passenger passenger: passengers) {
            System.out.println("Notification to : "+passenger.getName()+"about booking successful");
        }
    }

    public Payment book() {
        boolean isBookingValid = validateBooking();
        if(isBookingValid) {
            bookingManagement.updateBooking(this);
            return new Payment(this, calculatePrice());
        }
        return null;
    }

    private double calculatePrice() {
        double price = 0.0;
        for (Seat seat:seats) {
            price+=seat.getPrice();
        }
        return price;
    }

    private boolean validateBooking() {
        if(seats.size()!=passengers.size()) return false;
        for(Seat seat:seats) {
            if(!seat.isVacant()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = timeout - System.nanoTime();
        return unit.convert(diff, Timeunit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed otherDelayedTask) {
        return Long.compare(getDelay(Timeunit.NANOSECONDS),
                otherDelayedTask.getDelay(Timeunit.NANOSECONDS));
    }
}
