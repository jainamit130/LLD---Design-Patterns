package Examples.CarRentalSystem.Entities.Vehicle;

@FunctionalInterface
public interface Filter {
    boolean apply(Vehicle vehicle);
}
