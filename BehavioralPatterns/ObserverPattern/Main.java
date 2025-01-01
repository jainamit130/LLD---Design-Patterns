package BehavioralPatterns.ObserverPattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IObserver observer1 = new Observer("Observer 1");
        IObserver observer2 = new Observer("Observer 2");
        IObservable notifier = new Notifier(List.of(observer1,observer2));
        notifier.updateState(2);
        notifier.updateState(3);
    }
}
