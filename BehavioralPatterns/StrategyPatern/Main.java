package BehavioralPatterns.StrategyPatern;

import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.Duck;
import BehavioralPatterns.StrategyPatern.ConcreteClasses.MountainDuck;
import BehavioralPatterns.StrategyPatern.ConcreteStrategies.FlyStrategy.NoFly;
import BehavioralPatterns.StrategyPatern.ConcreteStrategies.FlyStrategy.NormalFly;
import BehavioralPatterns.StrategyPatern.ConcreteStrategies.FlyStrategy.SemiFly;
import BehavioralPatterns.StrategyPatern.ConcreteStrategies.SoundStrategy.quackSound;
import BehavioralPatterns.StrategyPatern.ConcreteStrategies.SoundStrategy.quackooSound;

public class Main {
    public static void main(String[] args) {
        Duck mountainDuck = new MountainDuck(
                "Mountain Duck",
                new quackooSound(),
                new NormalFly());

        Duck lakeDuck = new MountainDuck(
                "Lake Duck",
                new quackooSound(),
                new SemiFly());

        Duck rubberDuck = new MountainDuck(
                "Rubber Duck",
                new quackSound(),
                new NoFly());

        mountainDuck.quack();
        lakeDuck.quack();
        rubberDuck.quack();

        mountainDuck.fly();
        lakeDuck.fly();
        rubberDuck.fly();
    }
}
