package BehavioralPatterns.VisitorPattern;

import BehavioralPatterns.VisitorPattern.ConcreteClasses.Residence;
import BehavioralPatterns.VisitorPattern.ConcreteVisitor.InsuranceMail;
import BehavioralPatterns.VisitorPattern.ConcreteVisitor.LoanMail;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Client> clientList = new ArrayList<>();

        Visitor insuranceMail = new InsuranceMail();
        Visitor loanMail = new LoanMail();

        clientList.add(new Residence("Home"));
        clientList.add(new Residence("Restaurant"));
        clientList.add(new Residence("Residence"));
        for(Client client: clientList) {
            // Send insurance Mail
            client.accept(insuranceMail);
            // Send loan Mail == Open For Extension Closed For Modification
            client.accept(loanMail);
        }
    }
}
