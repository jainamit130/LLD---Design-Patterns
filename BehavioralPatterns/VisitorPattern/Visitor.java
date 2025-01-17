package BehavioralPatterns.VisitorPattern;

import BehavioralPatterns.VisitorPattern.ConcreteClasses.Company;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Residence;
import BehavioralPatterns.VisitorPattern.ConcreteClasses.Restaurant;

public interface Visitor {
    void visitRestaurant(Restaurant restaurant);
    void visitCompany(Company company);
    void visitResidence(Residence residence);
}


/*
*
* Notify
*
* Group => join,exit
* User => new chatroom
*
*
*
* */