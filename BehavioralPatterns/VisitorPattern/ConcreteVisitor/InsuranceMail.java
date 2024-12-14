package BehavioralPatterns.VisitorPattern.ConcreteVisitor;

import BehavioralPatterns.VisitorPattern.ConcreteClasses.Company;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Residence;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Restaurant;
import BehavioralPatterns.VisitorPattern.Visitor;

public class InsuranceMail implements Visitor {

    @Override
    public void visitRestaurant(Restaurant restaurant) {
        // Restaurant Insurance Email
        System.out.println(restaurant.getName()+" insurance mail sent");
    }

    @Override
    public void visitCompany(Company company) {
        // Company Insurance Email
        System.out.println(company.getName()+" insurance mail sent");
    }

    @Override
    public void visitResidence(Residence residence) {
        // Residence Insurance Email
        System.out.println(residence.getName()+" insurance mail sent");
    }
}
