package StructuralPatterns.CompositePattern.ConcreteClasses;

import StructuralPatterns.CompositePattern.Product;

public class StandardProduct implements Product {

    @Override
    public double getPrice() {
        return 100;
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
