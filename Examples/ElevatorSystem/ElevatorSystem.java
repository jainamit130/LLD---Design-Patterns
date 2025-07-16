package Examples.ElevatorSystem;

import Examples.ElevatorSystem.Entities.Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private static final ElevatorSystem instance = new ElevatorSystem();
    private static ElevatorStrategy strategy;
    private List<Elevator> elevators;
    private ElevatorSystem() {
        elevators = new ArrayList<>();
    }

    public static ElevatorSystem getInstance(ElevatorStrategy strategy) {
        ElevatorSystem.setStrategy(strategy);
        return instance;
    }

    public void addElevators(List<Elevator> elevators) {
        this.elevators.addAll(elevators);
    }

    public static void setStrategy(ElevatorStrategy strategy) {
        ElevatorSystem.strategy = strategy;
    }
}
