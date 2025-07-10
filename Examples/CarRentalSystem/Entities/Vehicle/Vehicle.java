package Examples.CarRentalSystem.Entities.Vehicle;

import Examples.CarRentalSystem.Entities.Store;

public abstract class Vehicle {
    private String vehicleId;
    private int seats;
    private String numberPlate;
    private VehicleType type;
    private double kilometersCovered;
    private Store store;
    //  private List<String> imageUrls;
    //  private Rating ratings;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
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
}
