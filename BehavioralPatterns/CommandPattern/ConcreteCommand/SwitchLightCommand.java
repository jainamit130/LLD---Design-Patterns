package BehavioralPatterns.CommandPattern.ConcreteCommand;

import BehavioralPatterns.CommandPattern.Interface.Command;
import BehavioralPatterns.CommandPattern.Receiver.Light;

public class SwitchLightCommand implements Command {

    public Light light;

    public SwitchLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLight();
    }
}
