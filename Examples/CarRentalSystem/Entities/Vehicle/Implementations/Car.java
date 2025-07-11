package Examples.CarRentalSystem.Entities.Vehicle.Implementations;

import Examples.CarRentalSystem.Entities.Location;
import Examples.CarRentalSystem.Entities.Store;
import Examples.CarRentalSystem.Entities.Vehicle.Vehicle;
import Examples.CarRentalSystem.Entities.Vehicle.VehicleType;

public class Car extends Vehicle {
    public Car(String carId, int seats, String numberPlate, Store store, Location designatedLocation) {
        super(carId, seats, numberPlate, VehicleType.CAR, designatedLocation, store);
    }
}
