package Examples.AirlineManagementSystem.entities.enums;

public enum FlightStatus {
    PENDING,
    SCHEDULED,
    DELAYED, // departure time shifted ahead
    IN_FLIGHT,
    CANCELLED,
    DIVERTED, // diverted to a different airport
}
