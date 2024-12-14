package BehavioralPatterns.StrategyPatern.ConcreteStrategies.FlyStrategy;

import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.FlyStrategy;

public class NormalFly implements FlyStrategy {
    @Override
    public void fly(String name) {
        System.out.println(name+" flies like a normal bird");
    }

}
