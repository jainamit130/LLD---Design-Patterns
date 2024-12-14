package BehavioralPatterns.TemplatePattern;

public abstract class Game implements GameLoader {
    public final void load() {
        byte[] data = loadLocalData();
        createObjects(data);
        downloadAdditionalFiles();
        initializeProfiles();
        cleanTempFiles();
    }
}
