package Examples.ShoppingCartCouponSystem.ConcreteClasses;

import Examples.ShoppingCartCouponSystem.Product;
import Examples.ShoppingCartCouponSystem.ProductType;

public class Shoes extends Product {

    public Shoes(String productId, double price) {
        super(productId, price, ProductType.FASHION);
    }
}
