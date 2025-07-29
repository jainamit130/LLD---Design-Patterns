package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public abstract class Product implements IProduct {
    protected String productId;
    protected double price;
    protected ProductType type;

    public Product(String productId, double price, ProductType type) {
        this.productId = productId;
        this.price = price;
        this.type = type;
    }

    public String getProductId() {
        return productId;
    }

    public ProductType getType() {
        return type;
    }

    @Override
    public double getPrice() throws CouponException {
        return price;
    }
}
