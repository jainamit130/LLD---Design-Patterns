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
        super();
        this.reservedSpots = new HashSet<>();
        this.parkingSpots = parkingSpots;
        priorityQueuesMap = new HashMap<>();
        for(EntryGate entryGate: entryGates) {
            entryGate.setAllocationStrategy(this);
            priorityQueuesMap.put(entryGate.getEntryGateId(),new HashMap<>());
            Map<ParkingType,PriorityQueue<WeightedItem>> entryGateQueuesMap = priorityQueuesMap.get(entryGate.getEntryGateId());
            for(ParkingType type: ParkingType.values()) {
                entryGateQueuesMap.put(type,new PriorityQueue<WeightedItem>((a, b) -> Integer.compare(a.getWeight(), b.getWeight())));
                PriorityQueue<WeightedItem> entryGateParkTypeQueue = entryGateQueuesMap.get(type);
            }
            for(ParkingSpot spot: parkingSpots) {
                String entryGateId = entryGate.getEntryGateId();
                PriorityQueue<WeightedItem> entryGateParkTypeQueue = entryGateQueuesMap.get(spot.getParkingType());
                entryGateParkTypeQueue.add(new WeightedItem(spot.getEntryWeight(entryGateId), spot.getParkingSpotId(), spot.getParkingType()));
            }
        }
    }

    public void addParkingTypeQueue(ParkingType type) {
        for(EntryGate entryGate: entryGates) {
            Map<ParkingType,PriorityQueue<WeightedItem>> entryGateQueuesMap = priorityQueuesMap.put(entryGate.getEntryGateId(),new HashMap<>());
            PriorityQueue<WeightedItem> entryGateParkTypeQueue = entryGateQueuesMap.put(type,new PriorityQueue<WeightedItem>((a, b) -> Integer.compare(a.getWeight(), b.getWeight())));
            for(ParkingSpot spot: parkingSpots) {
                entryGateParkTypeQueue.add(new WeightedItem(spot.getEntryWeight(entryGate.getEntryGateId()), spot.getParkingSpotId(), spot.getParkingType()));
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
    public WeightedItem getAllocatedParkingSpotId(String entryGateId,ParkingType type,String carNum) throws NoSpotAvailableException {
        PriorityQueue<WeightedItem> entryGateParkTypeQueue = priorityQueuesMap.get(entryGateId).get(type);
        while(!entryGateParkTypeQueue.isEmpty() && isReserved(entryGateParkTypeQueue.peek().getId())) {
            entryGateParkTypeQueue.remove();
        }

        ParkingType currParkingType = type;
        while(entryGateParkTypeQueue!=null && entryGateParkTypeQueue.isEmpty()) {
            currParkingType = ParkingType.getNextType(currParkingType);
            if(currParkingType==null) throw new NoSpotAvailableException();
            entryGateParkTypeQueue = priorityQueuesMap.get(entryGateId).get(currParkingType);
        }

        if(!entryGateParkTypeQueue.isEmpty()) {
            WeightedItem weightedItem = entryGateParkTypeQueue.poll();
            carToSpotIdMap.put(carNum,weightedItem.getId());
            reserve(weightedItem.getId());
            return weightedItem;
        }

        throw new NoSpotAvailableException();
    }
}
