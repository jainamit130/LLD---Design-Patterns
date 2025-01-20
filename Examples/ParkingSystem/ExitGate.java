package Examples.ParkingSystem;

import Examples.ParkingSystem.AllocationProcessStrategies.AllocationStrategy;
import Examples.ParkingSystem.StatePattern.Bill.Bill;

public class ExitGate {
    private String exitGateId;
    private AllocationStrategy allocationStrategy;

    private Bill generateBill(Token token) {
        return new Bill();
    }

    Bill process(Token token) {
        return generateBill(token);
    }
}
