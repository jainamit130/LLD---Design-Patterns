package Examples.ParkingSystem.AllocationProcessStrategies;

import Examples.ParkingSystem.EntryGate;
import Examples.ParkingSystem.Exceptions.NoSpotAvailableException;
import Examples.ParkingSystem.ParkingSpot;
import Examples.ParkingSystem.ParkingType;
import Examples.ParkingSystem.WeightedItem;

import java.util.*;

public class PriorityQueueAllocationStrategy extends AllocationStrategy {
    private List<ParkingSpot> parkingSpots;
    private List<EntryGate> entryGates;
    private Set<String> reservedSpots;
    private Map<String, Map<ParkingType,PriorityQueue<WeightedItem>>> priorityQueuesMap;

    public PriorityQueueAllocationStrategy(List<EntryGate> entryGates, List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
        priorityQueuesMap = new HashMap<>();
        for(EntryGate entryGate: entryGates) {
            Map<ParkingType,PriorityQueue<WeightedItem>> entryGateQueuesMap = priorityQueuesMap.put(entryGate.getEntryGateId(),new HashMap<>());
            for(ParkingType type: ParkingType.values()) {
                PriorityQueue<WeightedItem> entryGateParkTypeQueue = entryGateQueuesMap.put(type,new PriorityQueue<WeightedItem>((a, b) -> Integer.compare(a.getWeight(), b.getWeight())));
            }
            for(ParkingSpot spot: parkingSpots) {
                String entryGateId = entryGate.getEntryGateId();
                PriorityQueue<WeightedItem> entryGateParkTypeQueue = entryGateQueuesMap.get(spot.getParkingType());
                entryGateParkTypeQueue.add(new WeightedItem(spot.getEntryWeight(entryGateId), entryGateId));
            }
        }
    }

    public void addParkingTypeQueue(ParkingType type) {
        for(EntryGate entryGate: entryGates) {
            Map<ParkingType,PriorityQueue<WeightedItem>> entryGateQueuesMap = priorityQueuesMap.put(entryGate.getEntryGateId(),new HashMap<>());
            PriorityQueue<WeightedItem> entryGateParkTypeQueue = entryGateQueuesMap.put(type,new PriorityQueue<WeightedItem>((a, b) -> Integer.compare(a.getWeight(), b.getWeight())));
            for(ParkingSpot spot: parkingSpots) {
                entryGateParkTypeQueue.add(new WeightedItem(spot.getEntryWeight(entryGate.getEntryGateId()), entryGate.getEntryGateId()));
            }
        }
    }

    private boolean isReserved(String spotId) {
        return reservedSpots.contains(spotId);
    }

    private void reserve(String spotId) {
        reservedSpots.add(spotId);
    }

    private void unreserve(String spotId) {
        reservedSpots.remove(spotId);
    }

    @Override
    public void deallocateParkingSpotId(String carNum) {
        String spotId = carToSpotIdMap.get(carNum);
        unreserve(spotId);
    }

    @Override
    public String getAllocatedParkingSpotId(String entryGateId,ParkingType type,String carNum) {
        PriorityQueue<WeightedItem> entryGateParkTypeQueue = priorityQueuesMap.get(entryGateId).get(type);
        while(isReserved(entryGateParkTypeQueue.peek().getId())) {
            entryGateParkTypeQueue.remove();
        }

        ParkingType currParkingType = type;
        while(entryGateParkTypeQueue!=null && entryGateParkTypeQueue.isEmpty()) {
            currParkingType = ParkingType.getNextType(currParkingType);
            if(currParkingType==null) throw new NoSpotAvailableException();
            entryGateParkTypeQueue = priorityQueuesMap.get(entryGateId).get(currParkingType);
        }

        if(!entryGateParkTypeQueue.isEmpty()) {
            String allotedSpotId = entryGateParkTypeQueue.poll().getId();
            carToSpotIdMap.put(carNum,allotedSpotId);
            reserve(allotedSpotId);
            return allotedSpotId;
        }

        throw new NoSpotAvailableException();
    }
}
