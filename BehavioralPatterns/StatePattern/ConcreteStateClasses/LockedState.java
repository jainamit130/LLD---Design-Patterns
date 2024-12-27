package BehavioralPatterns.StatePattern.ConcreteStateClasses;

import BehavioralPatterns.StatePattern.Phone;
import BehavioralPatterns.StatePattern.State;

public class LockedState extends State {
    public LockedState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState(new ReadyState(phone));
        return phone.unlock();
    }

    @Override
    public String onPower() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
