package Examples.CarRentalSystem.Entities.Vehicle;

import Examples.CarRentalSystem.CarRentalSystem;
import Examples.CarRentalSystem.Entities.Location;
import Examples.CarRentalSystem.Entities.Store;

import java.time.Instant;

public abstract class Vehicle {
    private final String vehicleId;
    private final int seats;
    private final String numberPlate;
    private final VehicleType type;
    private final Location designatedLocation;
    private Location currentLocation;
    private double kilometersCovered;
    private Store store;

    protected Vehicle(String vehicleId, int seats, String numberPlate, VehicleType type, Location designatedLocation, Store store) {
        this.vehicleId = vehicleId;
        this.seats = seats;
        this.numberPlate = numberPlate;
        this.type = type;
        this.designatedLocation = designatedLocation;
        this.currentLocation = designatedLocation;
        this.store = store;
    }
    //  private List<String> imageUrls;
    //  private Rating ratings;

    public boolean isReserved(Instant pickupTime, Instant dropTime) {
        return CarRentalSystem.isReserved(this,pickupTime,dropTime);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Location getDesignatedLocation() {return designatedLocation; }

    public String getVehicleId() {
        return vehicleId;
    }

    public int getSeats() {
        return seats;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getType() {
        return type;
    }

    public double getKilometersCovered() {
        return kilometersCovered;
    }

    public void setKilometersCovered(double kilometersCovered) {
        this.kilometersCovered = kilometersCovered;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void updateCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", seats=" + seats +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }
}
