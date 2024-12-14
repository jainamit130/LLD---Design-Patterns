package BehavioralPatterns.StrategyPatern.ConcreteClasses;

import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.Duck;
import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.FlyStrategy;
import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.SoundStrategy;

public class RubberDuck extends Duck {
    public RubberDuck(String name,SoundStrategy soundStrategy, FlyStrategy flyStrategy) {
        super(name,soundStrategy, flyStrategy);
    }
}
