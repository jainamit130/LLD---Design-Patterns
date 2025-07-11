package Examples.CarRentalSystem.Entities.Vehicle;

import Examples.CarRentalSystem.Entities.Location;

import java.time.Instant;

public class FilterSystem {

    private static Filter byDistance(Location userLocation, long threshold) {
        return vehicle -> vehicle.getCurrentLocation().getDelta(userLocation)<=threshold;
    }

    private static Filter byTime(Instant pickupTime,Instant dropTime) {
        return vehicle -> !vehicle.isReserved(pickupTime,dropTime);
    }

    private static Filter byType(VehicleType type) {
        return vehicle -> vehicle.getType().equals(type);
    }

    private static Filter bySeat(int seats) {
        return vehicle -> vehicle.getSeats()==seats;
    }
}
