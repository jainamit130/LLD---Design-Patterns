package BehavioralPatterns.StrategyPatern.ConcreteStrategies.FlyStrategy;

import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.FlyStrategy;

public class SemiFly implements FlyStrategy {
    @Override
    public void fly(String name) {
        System.out.println(name+" semi flies");
    }
}
