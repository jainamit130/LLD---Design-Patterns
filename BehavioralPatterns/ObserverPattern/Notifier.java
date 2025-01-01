package BehavioralPatterns.ObserverPattern;

import java.util.List;

public class Notifier implements IObservable {
    private List<IObserver> observers;
    private Integer state;

    public Notifier(List<IObserver> observers) {
        this.observers = observers;
        state = 0;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public void updateState(Integer state) {
        setState(state);
        for(IObserver observer:observers) {
            notifyObserver(observer);
        }
    }

    public void notifyObserver(IObserver observer) {
        observer.update(this);
    }
}
