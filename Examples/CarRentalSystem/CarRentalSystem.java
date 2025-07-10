package Examples.CarRentalSystem;

import Examples.CarRentalSystem.Entities.Reservation.Reservation;
import Examples.CarRentalSystem.Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarRentalSystem {
    private final static CarRentalSystem instance = new CarRentalSystem();
    private final static CopyOnWriteArrayList<Reservation> reservations = new CopyOnWriteArrayList<>();
    private static final List<User> users = new ArrayList();

    private CarRentalSystem() {}

    public static boolean cancel(Reservation reservation) {
        return reservations.remove(reservation);
    }

    private static void addUsers(List<User> users) {
        CarRentalSystem.users.addAll(users);
    }

    public static boolean reserve(Reservation reservation) {
        return reservations.add(reservation);
    }
}
