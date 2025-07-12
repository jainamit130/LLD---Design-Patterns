package Examples.CarRentalSystem.Entities;

public class Location implements Diffable<Location,Long> {
    private String locationId;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private double latitude;
    private double longitude;

    public Location(String locationId, String address, String city, String pinCode, String state, double latitude, double longitude) {
        this.locationId = locationId;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    @Override
    public Long getDelta(Location obj) {
        // implement difference between 2 location
        return 10L;
    }
}
