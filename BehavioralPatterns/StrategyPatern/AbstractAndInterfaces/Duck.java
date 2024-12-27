package BehavioralPatterns.StrategyPatern.AbstractAndInterfaces;

import java.util.TreeMap;

public abstract class Duck {
    SoundStrategy soundStrategy;
    FlyStrategy flyStrategy;
    String name;

    public Duck(String name,SoundStrategy soundStrategy,FlyStrategy flyStrategy) {
        this.name = name;
        this.soundStrategy = soundStrategy;
        this.flyStrategy = flyStrategy;
    }

    public void quack() {
        soundStrategy.playSound(this.name);
    }

    public void fly() {
        flyStrategy.fly(this.name);
    }
}
