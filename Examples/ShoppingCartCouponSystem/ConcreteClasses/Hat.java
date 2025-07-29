package Examples.ShoppingCartCouponSystem.ConcreteClasses;

import Examples.ShoppingCartCouponSystem.Product;
import Examples.ShoppingCartCouponSystem.ProductType;

public class Hat extends Product {

    public Hat(String productId,double price) {
        super(productId, price, ProductType.FASHION);
    }
}
