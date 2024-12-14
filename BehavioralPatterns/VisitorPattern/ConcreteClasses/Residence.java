package BehavioralPatterns.VisitorPattern.ConcreteClasses;

import BehavioralPatterns.VisitorPattern.Client;
import BehavioralPatterns.VisitorPattern.Visitor;

public class Residence extends Client {

    public Residence(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitResidence(this);
    }
}
