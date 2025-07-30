package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public interface IProduct {
    // usually go for BigDecimal in such cases
    double getDiscountedPrice() throws CouponException;
    String getProductId();
    ProductType getType();
}
