package BehavioralPatterns.ChainOfResponsibilityPattern;

import BehavioralPatterns.ChainOfResponsibilityPattern.BaseHandler.Handler;
import BehavioralPatterns.ChainOfResponsibilityPattern.Client.AuthService;
import BehavioralPatterns.ChainOfResponsibilityPattern.ConcreteHandlers.PasswordCheckHandler;
import BehavioralPatterns.ChainOfResponsibilityPattern.ConcreteHandlers.RoleCheckHandler;
import BehavioralPatterns.ChainOfResponsibilityPattern.ConcreteHandlers.UserExistsHandler;
import BehavioralPatterns.ChainOfResponsibilityPattern.Request.Database;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Handler handler = new UserExistsHandler(database)
                .setNextHandler(new PasswordCheckHandler(database))
                .setNextHandler(new RoleCheckHandler());
        AuthService service = new AuthService(handler);
        service.login("admin_username","admin_password");
        service.login("user_username","user_password");
    }
}
