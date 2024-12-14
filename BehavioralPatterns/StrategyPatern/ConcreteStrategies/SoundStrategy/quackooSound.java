package BehavioralPatterns.StrategyPatern.ConcreteStrategies.SoundStrategy;

import BehavioralPatterns.StrategyPatern.AbstractAndInterfaces.SoundStrategy;

public class quackooSound implements SoundStrategy {
    @Override
    public void playSound(String name) {
            System.out.println(name+" quackoos!!");
    }
}
