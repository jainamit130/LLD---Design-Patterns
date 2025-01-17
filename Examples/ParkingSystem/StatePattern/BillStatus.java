package Examples.ParkingSystem.StatePattern;

public enum BillStatus {
    PENDING,        // Bill is pending in full
    PARTIALLY_PAID, // Some amount of money is paid
    OVERPAID,       // More than required amount is paid, helpful in scenarios of Credits or Change Money or Refund
    PAID,           // Bill is paid in full
    REFUNDED        // Entire paid amount has been refunded
}
