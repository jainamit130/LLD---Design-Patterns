package StructuralPatterns.AdapterPattern.Adapter;

import StructuralPatterns.AdapterPattern.interfaces.Adapter;
import StructuralPatterns.AdapterPattern.interfaces.Connector;
import StructuralPatterns.AdapterPattern.interfaces.Plugger;

public class ConnectToPlugAdapter implements Connector, Adapter {

    public Plugger plugger;

    public ConnectToPlugAdapter(Plugger plugger) {
        this.plugger = plugger;
    }

    @Override
    public void connect() {
        adapt();
    }

    @Override
    public void adapt() {
        System.out.println("Adapting connector to plugger...");
        plugger.plug();
    }
}
