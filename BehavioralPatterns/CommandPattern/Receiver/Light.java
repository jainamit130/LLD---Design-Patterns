package BehavioralPatterns.CommandPattern.Receiver;

public abstract class Light {
    public boolean isOn;

    public void switchLight() {
        this.isOn = !isOn;
        System.out.println("Toggled the "+this.getClass().getSimpleName()+"'s light!!!");
    }
}
