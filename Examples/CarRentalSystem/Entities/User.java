package Examples.CarRentalSystem.Entities;

import Examples.CarRentalSystem.Entities.Billing.Bill;
import Examples.CarRentalSystem.Entities.Reservation.Reservation;

import java.util.List;

public class User {
    private String userId;
    private String username;
    private String drivingLicense;
    // updates to reservation add and update (no removals)
    private List<Reservation> previousReservations;

    public Bill reserve(Reservation reservation) {
        return reservation.reserve();
    }
}
