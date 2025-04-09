package Examples.AirlineManagementSystem.entities.enums;

public enum PaymentStatus {
    PENDING,  // prcoess => pending to paid
    CANCELLED, // cancelled => does nothing
    PAID, // paid => does nothing already paid
    FAILED, // can be retried
    REFUNDED // refunded => does nothing
}
