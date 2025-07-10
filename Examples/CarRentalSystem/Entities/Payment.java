package Examples.CarRentalSystem.Entities;

import Examples.CarRentalSystem.Entities.Billing.Bill;

public class Payment {
    private Bill bill;
    private PaymentStatus status;
    private double amount;

    public boolean pay() {
        return true;
    }
}
