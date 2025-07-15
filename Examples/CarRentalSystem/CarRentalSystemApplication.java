package Examples.CarRentalSystem;

import Examples.CarRentalSystem.Entities.Billing.Bill;
import Examples.CarRentalSystem.Entities.InventoryManagement;
import Examples.CarRentalSystem.Entities.Location;
import Examples.CarRentalSystem.Entities.Payment.Payment;
import Examples.CarRentalSystem.Entities.Reservation.Reservation;
import Examples.CarRentalSystem.Entities.Store;
import Examples.CarRentalSystem.Entities.User;
import Examples.CarRentalSystem.Entities.Vehicle.FilterSystem;
import Examples.CarRentalSystem.Entities.Vehicle.Implementations.Car;
import Examples.CarRentalSystem.Entities.Vehicle.Vehicle;
import Examples.CarRentalSystem.Entities.Vehicle.VehicleType;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarRentalSystemApplication {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append(str);
        User user1 = new User("78692c28-18a4-4ae3-bf97-fe4d21934985", "Alice834", "DL-2679-881450");
        User user2 = new User("06bd141f-50e1-4260-8e24-e368c25fb9de", "Frank133", "DL-3775-232149");
        User user3 = new User("0e52d120-b35f-473c-b1ee-538f3dc93e33", "Frank716", "DL-3958-497516");

        Location loc1 = new Location("loc-1", "12 MG Road", "Bangalore", "560001", "Karnataka", 12.9716, 77.5946);
        Location loc2 = new Location("loc-2", "34 Carter Road", "Mumbai", "400052", "Maharashtra", 19.0760, 72.8777);
        Location loc3 = new Location("loc-3", "7 Banjara Hills", "Hyderabad", "500034", "Telangana", 17.3850, 78.4867);

        Store store1 = new Store("store-1", loc1, new InventoryManagement(new CopyOnWriteArrayList<>()));
        Store store2 = new Store("store-2", loc2, new InventoryManagement(new CopyOnWriteArrayList<>()));
        Store store3 = new Store("store-3", loc3, new InventoryManagement(new CopyOnWriteArrayList<>()));

        Car car1 = new Car(UUID.randomUUID().toString(), 4, "KA-01-AA-1234", store1, loc1);
        Car car2 = new Car(UUID.randomUUID().toString(), 5, "KA-05-BB-5678", store1, loc1);

        Car car3 = new Car(UUID.randomUUID().toString(), 4, "MH-12-CC-4321", store2, loc2);
        Car car4 = new Car(UUID.randomUUID().toString(), 6, "MH-14-DD-8765", store2, loc2);

        Car car5 = new Car(UUID.randomUUID().toString(), 4, "TS-07-EE-1122", store3, loc3);
        Car car6 = new Car(UUID.randomUUID().toString(), 5, "TS-09-FF-3344", store3, loc3);

        store1.addVehicleToInventory(car1);
        store1.addVehicleToInventory(car2);

        store2.addVehicleToInventory(car3);
        store2.addVehicleToInventory(car4);

        store3.addVehicleToInventory(car5);
        store3.addVehicleToInventory(car6);

        List<Vehicle> bangaloreCars = user1.search("Hyderabad", List.of(FilterSystem.byType(VehicleType.CAR)));
        System.out.println(bangaloreCars);

        if (!bangaloreCars.isEmpty()) {
            Vehicle hyderabadCar1 = bangaloreCars.get(0);
            Vehicle hyderabadCar2 = bangaloreCars.get(1 % bangaloreCars.size());

            Instant now = Instant.now();
            Instant pickupTime1 = now.plus(1, ChronoUnit.HOURS);
            Instant dropTime1 = pickupTime1.plus(6, ChronoUnit.HOURS);

            Instant pickupTime2 = now.plus(2, ChronoUnit.DAYS);
            Instant dropTime2 = pickupTime2.plus(1, ChronoUnit.DAYS);

            // Define usage locations (just reusing loc3 for simplicity)
            List<Location> usageRoute1 = List.of(loc3);
            List<Location> usageRoute2 = Arrays.asList(loc3, loc3); // simulate route with repeated location

            // Create reservations
            System.out.println("Creating reservations for user1...");
            Reservation reservation1 = user1.reserve(hyderabadCar1, pickupTime1, usageRoute1, dropTime1, 75.0);
            Reservation reservation2 = user1.reserve(hyderabadCar2, pickupTime2, usageRoute2, dropTime2, 130.0);

            Payment payment1 = new Payment(reservation1.getBill());
            reservation1 = user1.pay(reservation2.getBill(), payment1);

            System.out.println(reservation1);
            reservation1 = user1.activate(reservation1);

            System.out.println(reservation1);

            reservation1.complete(loc1);

            System.out.println(reservation1);
            Deque<Integer> dq = new LinkedList<>();
            dq.offer(5);
        }
    }
}
