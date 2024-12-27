package BehavioralPatterns.StatePattern.ConcreteStateClasses;

import BehavioralPatterns.StatePattern.Phone;
import BehavioralPatterns.StatePattern.State;

public class OffState extends State {

    public OffState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }

    @Override
    public String onPower() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }
}
