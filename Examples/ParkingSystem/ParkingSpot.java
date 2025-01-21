package Examples.ParkingSystem;

import Examples.ParkingSystem.Exceptions.NoEntryWeightException;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpot {
    private String parkingSpotId;
    private ParkingType parkingType;
    private Map<String,Integer> entryWeightMap;

    public ParkingSpot(String parkingSpotId,ParkingType parkingType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingType = parkingType;
        entryWeightMap = new HashMap<>();
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public Integer getEntryWeight(String entryGateId) throws NoEntryWeightException {
        return entryWeightMap.getOrDefault(entryGateId,entryWeightMap.size());
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public Map<String, Integer> getEntryWeightMap() {
        return entryWeightMap;
    }

    public void setEntryWeightMap(Map<String, Integer> entryWeightMap) {
        this.entryWeightMap = entryWeightMap;
    }
}
