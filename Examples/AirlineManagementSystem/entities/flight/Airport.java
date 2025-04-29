package Examples.AirlineManagementSystem.entities.flight;

public class Airport {
    private String airportId;
    private String address;

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Airport(String airportId, String address) {
        this.airportId = airportId;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "address='" + address + '\'' +
                '}';
    }
}
