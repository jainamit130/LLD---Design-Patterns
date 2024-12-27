package BehavioralPatterns.VisitorPattern;

import BehavioralPatterns.VisitorPattern.ConcreteClasses.Company;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Residence;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Restaurant;
import BehavioralPatterns.VisitorPattern.ConcreteVisitor.InsuranceMail;
import BehavioralPatterns.VisitorPattern.ConcreteVisitor.LoanMail;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Client> clientList = new ArrayList<>();

        Visitor insuranceMail = new InsuranceMail();
        Visitor loanMail = new LoanMail();

        clientList.add(new Company("Home"));
        clientList.add(new Residence("Residence"));
        clientList.add(new Restaurant("Restaurant"));
        for(Client client: clientList) {
            // Send insurance Mail
            client.accept(insuranceMail);
            // Send loan Mail == Open For Extension Closed For Modification
            client.accept(loanMail);
        }
    }
}
