package Examples.ParkingSystem;

public class EntryGate {
    private String entryGateId;

    Token generateToken(Vehicle vehicle) {
        return new Token();
    }

    Token process(Vehicle vehicle){
        return generateToken(vehicle);
    }
}
