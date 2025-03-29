package StructuralPatterns.AdapterPattern.Plugs;

import StructuralPatterns.AdapterPattern.interfaces.Plugger;

public class USAPlug implements Plugger {

    @Override
    public void plug() {
        System.out.println("Usa Plugger plugs!");
    }
}
