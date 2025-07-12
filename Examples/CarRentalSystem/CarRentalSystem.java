package Examples.CarRentalSystem;

import Examples.CarRentalSystem.Entities.Reservation.Reservation;
import Examples.CarRentalSystem.Entities.Store;
import Examples.CarRentalSystem.Entities.User;
import Examples.CarRentalSystem.Entities.Vehicle.Filter;
import Examples.CarRentalSystem.Entities.Vehicle.Vehicle;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarRentalSystem {
    private final static CarRentalSystem instance = new CarRentalSystem();
    private final static Map<String, List<Store>> cityToStoresMap = new HashMap<>();
    private final static CopyOnWriteArrayList<Reservation> reservations = new CopyOnWriteArrayList<>();
    private static final List<User> users = new ArrayList();

    private CarRentalSystem() {}

    public CarRentalSystem getInstance() {
        return instance;
    }

    public static boolean remove(Reservation reservation) {
        return reservations.remove(reservation);
    }

    private static void addUsers(List<User> users) {
        CarRentalSystem.users.addAll(users);
    }

    public static boolean reserve(Reservation reservation) {
        return reservations.add(reservation);
    }

    public static boolean isReserved(Vehicle vehicle, Instant pickupTime, Instant dropTime) {
        return reservations.stream()
                .filter(reservation -> reservation.getVehicle().equals(vehicle))
                .anyMatch(reservation -> reservation.isReserved(pickupTime, dropTime));
    }

    public static void addStore(Store store) {
        String city = store.getLocation().getCity().toLowerCase();
        cityToStoresMap.computeIfAbsent(city, k -> new ArrayList<>()).add(store);
    }

    public static List<Vehicle> search(String city, List<Filter> filters) {
        List<Store> storesInCity = cityToStoresMap.getOrDefault(city.toLowerCase(), new ArrayList<>());
        List<Vehicle> results = new ArrayList<>();

        for (Store store : storesInCity) results.addAll(store.getVehicleInventory().search(filters));
        return results;
    }


}
