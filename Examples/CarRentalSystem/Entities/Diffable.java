package Examples.CarRentalSystem.Entities;

@FunctionalInterface
public interface Diffable<T,R extends Number> {
    R getDelta(T obj);
}
