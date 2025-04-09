package Examples.AirlineManagementSystem.entities.enums;

public enum BookingStatus {
    PENDING, // Payment missing or payment to be processed
    BOOKED, // Payment processed
    CANCELLED // Payment refunded
}
