package Examples.ParkingSystem;

import Examples.ParkingSystem.AllocationProcessStrategies.AllocationStrategy;

public class EntryGate {
    private String entryGateId;
    private AllocationStrategy allocationStrategy;

    Token generateToken(ParkingType vehicle) {
        return new Token();
    }

    Token process(ParkingType parkingType){
        return generateToken(parkingType);
    }

    public String getEntryGateId() {
        return entryGateId;
    }

    public void setEntryGateId(String entryGateId) {
        this.entryGateId = entryGateId;
    }
}
