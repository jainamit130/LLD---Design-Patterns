package Examples.CarRentalSystem.Entities;

import Examples.CarRentalSystem.Entities.Vehicle.Filter;
import Examples.CarRentalSystem.Entities.Vehicle.Vehicle;
import Examples.CarRentalSystem.Entities.Vehicle.VehicleType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class InventoryManagement {
    private static final CopyOnWriteArrayList<Vehicle> vehicles = new CopyOnWriteArrayList<>();
    private static final Map<VehicleType,Integer> vehicleCountMap = new ConcurrentHashMap<>();

    public InventoryManagement(CopyOnWriteArrayList<Vehicle> vehicles) {
        vehicles.stream().forEach((Vehicle vehicle) -> {
            addVehicle(vehicle);
        });
    }

    public static void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicleCountMap.put(vehicle.getType(),vehicleCountMap.getOrDefault(vehicle.getType(),0)+1);
    }

    private static void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicleCountMap.put(vehicle.getType(),vehicleCountMap.getOrDefault(vehicle.getType(),0)-1);
    }

    public List<Vehicle> search(List<Filter> filters) {
        // search would filter out vehicles which are reserved for that duration
        return vehicles.stream()
                .filter(vehicle -> filters.stream().allMatch(filter -> filter.apply(vehicle)))
                .collect(Collectors.toList());
    }
}
