package Examples.CarRentalSystem.Entities;

public class Location implements Diffable<Location,Long> {
    String address;
    String city;
    String pinCode;
    String state;
    double latitude;
    double longitude;


    @Override
    public Long getDelta(Location obj) {
        // implement difference between 2 location
        return 10L;
    }
}
