package BehavioralPatterns.ObserverPattern;

public class Observer implements IObserver {
    private String name;
    public Observer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(IObservable observable) {
        System.out.println(getName() + " is notified for updated state of " + observable.getState() + " of observable" );
    }
}
