package BehavioralPatterns.ChainOfResponsibilityPattern.ConcreteHandlers;

import BehavioralPatterns.ChainOfResponsibilityPattern.BaseHandler.Handler;
import BehavioralPatterns.ChainOfResponsibilityPattern.Request.Database;

public class UserExistsHandler extends Handler {
    private Database database;

    public UserExistsHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!database.isValidUsername(username)) {
            System.out.println("user is invalid");
        }
        return handleNext(username,password);
    }


}
