package Examples.ElevatorSystem.Entities.Command;

public interface Command {
    default void execute() {
        System.out.println("No action command!");
    }
}
