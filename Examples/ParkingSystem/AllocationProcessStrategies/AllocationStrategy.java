package Examples.ParkingSystem.AllocationProcessStrategies;

import Examples.ParkingSystem.Exceptions.NoSpotAvailableException;
import Examples.ParkingSystem.ParkingType;
import Examples.ParkingSystem.WeightedItem;

import java.util.HashMap;
import java.util.Map;

public abstract class AllocationStrategy {
    protected Map<String,String> carToSpotIdMap;

    public AllocationStrategy() {
        carToSpotIdMap = new HashMap<>();
    }

    public abstract WeightedItem getAllocatedParkingSpotId(String entryGateId, ParkingType type, String carNum) throws NoSpotAvailableException;
    public abstract void deallocateParkingSpotId(String carNum);
}
