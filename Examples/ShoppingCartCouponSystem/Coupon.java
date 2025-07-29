package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public abstract class Coupon extends CartProduct {
    protected String couponId;
    protected double discount;
    protected CartProduct product;
    protected int usage;

    public Coupon(String couponId, double discount, CartProduct product, int usage) throws CouponException {
        super(product.getCart(),product);
        this.couponId = couponId;
        this.discount = discount;
        this.product = product;
        this.usage = usage;
    }

    protected boolean validate() throws CouponException {
        return validateCoupon(this) && usage!=0;
    }

    @Override
    public final double getPrice() throws CouponException {
        double price = product.getPrice();
        if(validate()) {
            apply();
            return price * ((100-discount) / 100.0);
        }
        return price;
    }

    protected void apply() {
        usage--;
        product.applyCoupon(this);
    }
}
