package BehavioralPatterns.StrategyPatern.ConcreteClasses;

import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.Duck;
import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.FlyStrategy;
import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.SoundStrategy;

public class MountainDuck extends Duck {
    public MountainDuck(String name,SoundStrategy soundStrategy, FlyStrategy flyStrategy) {
        super(name,soundStrategy, flyStrategy);
    }
}
