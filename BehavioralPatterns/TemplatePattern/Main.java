package BehavioralPatterns.TemplatePattern;

import BehavioralPatterns.TemplatePattern.ConcreteClasses.GTA6;
import BehavioralPatterns.TemplatePattern.ConcreteClasses.RedDeadRedemption;

public class Main {
    public static void main(String[] args) {
        Game gta6 = new GTA6();
        gta6.load();
        System.out.println("------------------------------------");
        Game rdr = new RedDeadRedemption();
        rdr.load();
    }
}
