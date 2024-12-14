package BehavioralPatterns.TemplatePattern;

public interface GameLoader {
    void load();
    void cleanTempFiles();
    byte[] loadLocalData();
    void createObjects(byte[] data);
    void downloadAdditionalFiles();
    void initializeProfiles();
}
