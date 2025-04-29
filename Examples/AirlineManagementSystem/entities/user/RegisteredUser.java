package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.service.Booking.BookingService;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;

public class RegisteredUser extends User {

    protected String name;
    protected Account account;

    public RegisteredUser(String userId,String name, Account account) {
        super(userId);
        this.name = name;
        this.account = account;
    }

    // Should be able to book flights
    public Booking bookFlight(BookingService bookingService, Booking booking) {
        if(!booking.belongsTo(this)) System.out.println("No such booking exists for you!");
        return bookingService.book(booking);
    }

    public Booking confirm(BookingService bookingService, Booking booking, Payment payment) {
        if(!payment.validatePayment()) {
            System.out.println("Invalid payment details!");
            return null;
        }
        if(!booking.belongsTo(this)) System.out.println("No such booking exists for you!");
        bookingService.confirm(booking,payment);
        return booking;
    }

    public String getName() {
        return name;
    }
}
