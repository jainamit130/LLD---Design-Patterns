package Examples.AirlineManagementSystem.entities.enums;

public enum FlightStatus {
    PENDING,
    SCHEDULED,
    DELAYED, // departure time shifted ahead
    CANCELLED,
    DIVERTED, // diverted to a different airport
}
