package BehavioralPatterns.TemplatePattern.ConcreteClasses;

import BehavioralPatterns.TemplatePattern.Game;

public class RedDeadRedemption extends Game {

    @Override
    public void cleanTempFiles() {
        System.out.println("Step5: Cleaning Temp Files...");
        System.out.println("Red Dead Redemption Started...");
    }

    @Override
    public byte[] loadLocalData() {
        System.out.println("Starting Red Dead Redemption...");
        System.out.println("Step1: Loading Local Data...");
        return new byte[0];
    }

    @Override
    public void createObjects(byte[] data) {
        System.out.println("Step2: Creating Objects...");
    }

    @Override
    public void downloadAdditionalFiles() {
        System.out.println("Step3: Downloading Additional Files...");
    }

    @Override
    public void initializeProfiles() {
        System.out.println("Step4: Loading saved game...");
    }
}
