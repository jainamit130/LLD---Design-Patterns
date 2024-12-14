package BehavioralPatterns.VisitorPattern;

public abstract class Client {

    protected String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept(Visitor visitor);
}
