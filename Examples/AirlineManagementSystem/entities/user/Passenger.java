package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.entities.flight.State.Flight;

public class Passenger extends User {
    private String name;
    private String phone;
    private String email;
    private int age;
    private int baggageCount;

    public Passenger(String userId,String name, String phone, String email, int age, int baggageCount) {
        super(userId);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.baggageCount = baggageCount;
    }

    public void notifyPassenger(Flight flight) {
        System.out.println("To passenger "+name+" - "+flight.getFlightId()+" - "+flight.getFlightState().getStatus());
    }

    public String getName() {
        return name;
    }
}
