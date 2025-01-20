package Examples.ParkingSystem.AllocationProcessStrategies;

import Examples.ParkingSystem.ParkingType;

import java.util.Map;

public abstract class AllocationStrategy {
    protected Map<String,String> carToSpotIdMap;

    public abstract String getAllocatedParkingSpotId(String entryGateId, ParkingType type, String carNum);
    public abstract void deallocateParkingSpotId(String carNum);
}
