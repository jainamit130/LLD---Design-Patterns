package Examples.ShoppingCartCouponSystem.ConcreteClasses;

import Examples.ShoppingCartCouponSystem.Product;
import Examples.ShoppingCartCouponSystem.ProductType;

public class Electronics extends Product {

    public Electronics(String productId, double price) {
        super(productId, price, ProductType.ELECTRONICS);
    }
}
