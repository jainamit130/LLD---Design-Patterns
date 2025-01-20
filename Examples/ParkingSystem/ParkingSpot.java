package Examples.ParkingSystem;

import Examples.ParkingSystem.Exceptions.NoEntryWeightException;

import java.util.Map;

public class ParkingSpot {
    private String parkingSpotId;
    private ParkingType parkingType;
    private Integer floor;
    private SpotStatus status;
    private Map<String,Integer> entryWeightMap;

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
}
