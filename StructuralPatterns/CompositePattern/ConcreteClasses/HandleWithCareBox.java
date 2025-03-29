package StructuralPatterns.CompositePattern.ConcreteClasses;

import StructuralPatterns.CompositePattern.Box;

public class HandleWithCareBox implements Box {

    public Box box;

    public HandleWithCareBox(Box box) {
        this.box = box;
    }

    public double getPrice() {
        return 100;
    }

    @Override
    public double calculatePrice() {
        return getPrice()+box.calculatePrice();
    }
}
