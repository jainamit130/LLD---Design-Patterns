package StructuralPatterns.CompositePattern.ConcreteClasses;

import StructuralPatterns.CompositePattern.Product;

public class PremiumProduct implements Product {

    @Override
    public double getPrice() {
        return 200;
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
