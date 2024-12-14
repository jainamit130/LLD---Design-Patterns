package BehavioralPatterns.VisitorPattern.ConcreteVisitor;

import BehavioralPatterns.VisitorPattern.ConcreteClasses.Company;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Residence;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Restaurant;
import BehavioralPatterns.VisitorPattern.Visitor;

public class LoanMail implements Visitor {
    @Override
    public void visitRestaurant(Restaurant restaurant) {
        // Restaurant Loan Email
        System.out.println(restaurant.getName()+" loan mail sent");
    }

    @Override
    public void visitCompany(Company company) {
        // Company Loan Email
        System.out.println(company.getName()+" loan mail sent");
    }

    @Override
    public void visitResidence(Residence residence) {
        // Residence Loan Email
        System.out.println(residence.getName()+" loan mail sent");
    }
}
