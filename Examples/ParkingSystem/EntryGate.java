package Examples.ParkingSystem;

import Examples.ParkingSystem.AllocationProcessStrategies.AllocationStrategy;
import Examples.ParkingSystem.Exceptions.NoSpotAvailableException;

import java.time.Instant;

public class EntryGate {
    private String entryGateId;
    private AllocationStrategy allocationStrategy;
    private ExitGate exitGate;

    public EntryGate(String entryGateId) {
        this.entryGateId = entryGateId;
    }

    public void setAllocationStrategy(AllocationStrategy allocationStrategy) {
        this.allocationStrategy = allocationStrategy;
    }

    public void setExitGate(ExitGate exitGate) {
        this.exitGate = exitGate;
    }

    private Token generateToken(ParkingType parkType, String carNum,Parker parker) throws NoSpotAvailableException {
        WeightedItem weightedSpot = allocateSpot(parkType,carNum);
        return new Token(parker,weightedSpot.getId(),carNum,weightedSpot.getType(), Instant.now());
    }

    Token process(ParkingType parkingType,String carNum,Parker parker) throws NoSpotAvailableException {
        return generateToken(parkingType,carNum,parker);
    }

    public String getEntryGateId() {
        return entryGateId;
    }

    public void setEntryGateId(String entryGateId) {
        this.entryGateId = entryGateId;
    }

    public ExitGate getCorrespondingExitGate() {
        return exitGate;
    }

    private WeightedItem allocateSpot(ParkingType parkingType,String carNum) throws NoSpotAvailableException {
        return allocationStrategy.getAllocatedParkingSpotId(getEntryGateId(),parkingType,carNum);
    }

    public void deallocateSpot(String carNum) {
        allocationStrategy.deallocateParkingSpotId(carNum);
    }
}
