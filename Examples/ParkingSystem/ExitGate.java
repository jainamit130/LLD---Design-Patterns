package Examples.ParkingSystem;

public class ExitGate {
    private String exitGateId;

    private Bill generateBill(Token token) {
        return new Bill();
    }

    Bill process(Token token) {
        return generateBill(token);
    }
}
