package StructuralPatterns.CompositePattern.ConcreteClasses;

import StructuralPatterns.CompositePattern.Box;

public class StandardBox implements Box {

    public Box box;

    public StandardBox(Box box) {
        this.box = box;
    }

    @Override
    public double getPrice() {
        return 50;
    }
    
    @Override
    public double calculatePrice() {
        return getPrice()+box.calculatePrice();
    }
}
