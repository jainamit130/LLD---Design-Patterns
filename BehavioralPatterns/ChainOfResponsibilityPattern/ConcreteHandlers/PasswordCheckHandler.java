package BehavioralPatterns.ChainOfResponsibilityPattern.ConcreteHandlers;

import BehavioralPatterns.ChainOfResponsibilityPattern.BaseHandler.Handler;
import BehavioralPatterns.ChainOfResponsibilityPattern.Request.Database;

public class PasswordCheckHandler extends Handler {
    private Database database;

    public PasswordCheckHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!database.isValidPassword(username,password)) {
            System.out.println("password is invalid");
        }
        return handleNext(username,password);
    }

}
