package Examples.CarRentalSystem.Entities;

import Examples.CarRentalSystem.CarRentalSystem;
import Examples.CarRentalSystem.Entities.Vehicle.Vehicle;

public class Store {
    private String storeId;
    private Location location;
    private InventoryManagement vehicleInventory;

    public Store(String storeId, Location location, InventoryManagement vehicleInventory) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventory = vehicleInventory;
        CarRentalSystem.addStore(this);
    }

    public InventoryManagement getVehicleInventory() {
        return vehicleInventory;
    }

    public Location getLocation() {
        return location;
    }

    public void addVehicleToInventory(Vehicle vehicle) {
        vehicleInventory.addVehicle(vehicle);
    }
}
