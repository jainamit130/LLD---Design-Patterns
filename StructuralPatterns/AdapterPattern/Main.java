package StructuralPatterns.AdapterPattern;

import StructuralPatterns.AdapterPattern.Adapter.ConnectToPlugAdapter;
import StructuralPatterns.AdapterPattern.Adapter.PlugToConnectAdapter;
import StructuralPatterns.AdapterPattern.Plugs.INDPlug;
import StructuralPatterns.AdapterPattern.Plugs.USAPlug;
import StructuralPatterns.AdapterPattern.interfaces.Connector;
import StructuralPatterns.AdapterPattern.interfaces.Plugger;

public class Main {
    public static void main(String[] args) {
        Plugger usaPlugger = new USAPlug();
        Connector indConnector = new INDPlug();
        ConnectToPlugAdapter connectorToPlugger = new ConnectToPlugAdapter(usaPlugger);
        connectorToPlugger.connect();

        PlugToConnectAdapter plugToConnectAdapter = new PlugToConnectAdapter(indConnector);
        plugToConnectAdapter.plug();
    }
}
