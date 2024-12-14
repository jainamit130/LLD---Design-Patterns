package BehavioralPatterns.ChainOfResponsibilityPattern.ConcreteHandlers;

import BehavioralPatterns.ChainOfResponsibilityPattern.BaseHandler.Handler;

public class RoleCheckHandler extends Handler {
    @Override
    public boolean handle(String username, String password) {
        if(username.equals("admin_username")) {
            System.out.println("Load Admin Page...");
            return true;
        }
        System.out.println("Load User Page...");
        return handleNext(username,password);
    }

}
