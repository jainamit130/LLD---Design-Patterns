package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.entities.flight.Flight;

public class Passenger extends User {
    private String name;
    private String phone;
    private String email;
    private int age;
    private int baggageCount;

    public void notifyPassenger(Flight flight) {
        System.out.println("To passenger "+name+" - "+flight.getFlightId()+" has been "+flight.getFlightState().getStatus());
    }

    public String getName() {
        return name;
    }
}
