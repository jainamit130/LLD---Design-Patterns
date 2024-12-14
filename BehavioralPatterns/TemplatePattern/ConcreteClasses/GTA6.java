package BehavioralPatterns.TemplatePattern.ConcreteClasses;

import BehavioralPatterns.TemplatePattern.Game;

public class GTA6 extends Game {

    @Override
    public void cleanTempFiles() {
        System.out.println("Step5: Cleaning Temp Files...");
        System.out.println("Grand Theft Auto 6 Started...");
    }

    @Override
    public byte[] loadLocalData() {
        System.out.println("Starting Grand Theft Auto 6...");
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
