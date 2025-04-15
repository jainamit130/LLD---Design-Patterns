package Examples.AirlineManagementSystem.entities.enums;

public enum BookingStatus {
    PENDING,       // Seat is temporarily held, payment in progress
    RESERVED,
    CONFIRMED,     // Payment successful, seat locked
    CANCELLED,     // User or system cancelled the booking
    EXPIRED,       // Payment window expired, seat released
    FAILED         // Payment failed or Invalid Booking
}


/*

PENDING	User selects seat, starts booking flow ->	CONFIRMED, CANCELLED, EXPIRED, FAILED
CONFIRMED	Payment successful -> CANCELLED
CANCELLED	User cancels manually or flight is canceled	-> Final state
EXPIRED	Booking not completed within timeout window	-> PENDING
FAILED	Payment error, gateway failure, etc. -> PENDING


* */