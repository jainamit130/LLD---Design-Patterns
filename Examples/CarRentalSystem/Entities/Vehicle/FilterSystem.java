package Examples.CarRentalSystem.Entities.Vehicle;

import Examples.CarRentalSystem.Entities.Location;
import Examples.CarRentalSystem.Entities.Store;

import java.time.Instant;

public class FilterSystem {

    public static Filter byDistance(Location userLocation, long threshold) {
        return vehicle -> vehicle.getCurrentLocation().getDelta(userLocation)<=threshold;
    }

    public static Filter byTime(Instant pickupTime,Instant dropTime) {
        return vehicle -> !vehicle.isReserved(pickupTime,dropTime);
    }

    public static Filter byType(VehicleType type) {
        return vehicle -> vehicle.getType().equals(type);
    }

    public static Filter bySeat(int seats) {
        return vehicle -> vehicle.getSeats()==seats;
    }

    public static Filter byCity(String city)  {
        return vehicle -> vehicle.getCurrentLocation().getCity().equals(city);
    }

    public static Filter byStore(Store store)  {
        return vehicle -> vehicle.getStore().equals(store);
    }
}
