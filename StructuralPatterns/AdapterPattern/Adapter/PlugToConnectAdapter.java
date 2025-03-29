package StructuralPatterns.AdapterPattern.Adapter;

import StructuralPatterns.AdapterPattern.interfaces.Adapter;
import StructuralPatterns.AdapterPattern.interfaces.Connector;
import StructuralPatterns.AdapterPattern.interfaces.Plugger;

public class PlugToConnectAdapter implements Plugger, Adapter {

    public Connector connector;

    public PlugToConnectAdapter(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void plug() {
        adapt();
    }

    public void adapt() {
        System.out.println("Adapting plugger to connector...");
        connector.connect();
    }
}
