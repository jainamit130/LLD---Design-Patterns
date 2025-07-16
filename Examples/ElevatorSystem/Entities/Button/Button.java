package Examples.ElevatorSystem.Entities.Button;

import Examples.ElevatorSystem.Entities.Command.Command;

public class Button implements IButton {
    private Command command;

    public Button() {}

    public void setCommand(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }
}
