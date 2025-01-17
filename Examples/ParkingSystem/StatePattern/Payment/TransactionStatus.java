package Examples.ParkingSystem.StatePattern.Payment;

public enum TransactionStatus {
    PENDING,        // Transaction is still processing
    PAID,      // Transaction is completed
    FAILED,         // Transaction failed
    REFUNDED        // Transaction has been refunded
}
