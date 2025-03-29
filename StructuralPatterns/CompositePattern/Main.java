package StructuralPatterns.CompositePattern;

import StructuralPatterns.CompositePattern.ConcreteClasses.HandleWithCareBox;
import StructuralPatterns.CompositePattern.ConcreteClasses.PremiumProduct;
import StructuralPatterns.CompositePattern.ConcreteClasses.StandardBox;
import StructuralPatterns.CompositePattern.ConcreteClasses.StandardProduct;

public class Main {
    public static void main(String[] args) {
        // Standard Box -> HandleWithCare Box -> Premium Product
        StandardBox standardBox = new StandardBox(
                new HandleWithCareBox(
                        new PremiumProduct()
                )
        );
        // 50 + 100 + 200 = 350
        System.out.println(standardBox.calculatePrice());

        // Standard Box -> Standard Box -> Standard Box -> Standard Product
        StandardBox standardBox1 = new StandardBox(
                new StandardBox(
                        new StandardBox(
                            new StandardProduct()
                        )
                )
        );

        // 50 + 50 + 50 + 100 = 250
        System.out.println(standardBox1.calculatePrice());
    }
}
