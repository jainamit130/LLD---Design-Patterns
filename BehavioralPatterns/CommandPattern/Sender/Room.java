package BehavioralPatterns.CommandPattern.Sender;

import BehavioralPatterns.CommandPattern.Interface.Command;

public class Room {
    public Command command;

    public Room() {}
    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
