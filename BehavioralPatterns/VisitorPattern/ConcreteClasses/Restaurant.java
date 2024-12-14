package BehavioralPatterns.VisitorPattern.ConcreteClasses;

import BehavioralPatterns.VisitorPattern.Client;
import BehavioralPatterns.VisitorPattern.Visitor;

public class Restaurant extends Client {

    public Restaurant(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRestaurant(this);
    }
}
