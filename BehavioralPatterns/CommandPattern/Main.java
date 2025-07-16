package BehavioralPatterns.CommandPattern;

import BehavioralPatterns.CommandPattern.ConcreteCommand.SwitchLightCommand;
import BehavioralPatterns.CommandPattern.Receiver.FloorLamp;
import BehavioralPatterns.CommandPattern.Receiver.NightLight;
import BehavioralPatterns.CommandPattern.Receiver.TubeLight;
import BehavioralPatterns.CommandPattern.Sender.LivingRoom;
import BehavioralPatterns.CommandPattern.Sender.Room;

public class Main {
    public static void main(String[] args) {
        Room livingRoom = new LivingRoom();
        livingRoom.setCommand(new SwitchLightCommand(new FloorLamp()));
        livingRoom.executeCommand();
    }
}
