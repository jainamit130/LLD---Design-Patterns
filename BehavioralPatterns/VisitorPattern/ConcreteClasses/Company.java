package BehavioralPatterns.VisitorPattern.ConcreteClasses;

import BehavioralPatterns.VisitorPattern.Client;
import BehavioralPatterns.VisitorPattern.Visitor;

public class Company extends Client {

    public Company(String name) {
        super(name);
    }

    // Single Responsibility
    @Override
    public void accept(Visitor visitor) {
        visitor.visitCompany(this);
    }
}
