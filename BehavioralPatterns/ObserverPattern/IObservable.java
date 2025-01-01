package BehavioralPatterns.ObserverPattern;

public interface IObservable {
    void updateState(Integer state);
    Integer getState();
}
