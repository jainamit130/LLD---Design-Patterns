package StructuralPatterns.AdapterPattern.Plugs;

import StructuralPatterns.AdapterPattern.interfaces.Connector;

public class INDPlug implements Connector {
    @Override
    public void connect() {
        System.out.println("Ind Plugger connects!");
    }
}
