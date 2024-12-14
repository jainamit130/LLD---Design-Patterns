package BehavioralPatterns.ChainOfResponsibilityPattern.Client;

import BehavioralPatterns.ChainOfResponsibilityPattern.BaseHandler.Handler;

public class AuthService {
    private Handler handler;

    public AuthService(Handler handler){
        this.handler = handler;
    }

    public boolean login(String username,String password) {
        if(handler.handle(username,password)) {
            System.out.println("You are logged in!");
            //....
            return true;
        }
        return false;
    }
}
