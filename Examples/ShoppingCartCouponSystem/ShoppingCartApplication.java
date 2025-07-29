package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.ConcreteClasses.*;
import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public class ShoppingCartApplication {

    public static void main(String[] args) {
        try {
            Shoes shoes1 = new Shoes("adidas1", 2500.0);
            Shoes shoes2 = new Shoes("reebok1", 1555.0);
            Shoes shoes3 = new Shoes("puma1", 4000.0);
            Hat hat = new Hat("Zara", 5400.0);
            Electronics electronics1 = new Electronics("mac1", 184900.0);
            Electronics electronics2 = new Electronics("oneplusbuds1", 18490.0);

            ShoppingCart cart = new ShoppingCart("cart1");
            CartProduct cartProd1 = new CartProduct(cart,shoes1);
            CartProduct cartProd2 = new CartProduct(cart,electronics1);
            CartProduct cartProd3 = new CartProduct(cart,shoes2);
            CartProduct cartProd4 = new CartProduct(cart,hat);
            CartProduct cartProd5 = new CartProduct(cart,electronics2);

            cart.addProduct(cartProd1);
            cart.addProduct(cartProd2);
            cart.addProduct(cartProd3);
            cart.addProduct(cartProd4);
            cart.addProduct(cartProd5);

            double total = 0;
            for(CartProduct product : cart.getProducts()) {
                double subTotal = new ItemNDiscountCoupon("NItemDiscount",10,2,ProductType.ELECTRONICS,new DiscountCoupon("FLAT10",10,product)).getPrice();
                System.out.println(product.getProductId() + " " + subTotal);
                total += subTotal;
            }

            System.out.println(total);
        } catch (CouponException e) {
            System.out.println(e.getMessage());
        }

    }
}
