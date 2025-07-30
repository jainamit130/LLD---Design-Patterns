package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

import java.util.Objects;

public abstract class Coupon extends CartProduct {
    private String couponId;
    private double discount;
    protected CartProduct product;
    protected CouponType type;

    public Coupon(String couponId, double discount, CartProduct product,CouponType type) throws CouponException {
        super(product.getCart(),product);
        this.couponId = couponId;
        this.discount = discount;
        this.product = product;
        this.type = type;
    }

    public CouponType getCouponType() {
        return type;
    }

    public String getCouponId() {
        return couponId;
    }

    protected boolean validate() throws CouponException {
        return validateCoupon(this);
    }

    @Override
    public final double getDiscountedPrice() throws CouponException {
        double price = super.getDiscountedPrice();
        if(validate()) {
            apply();
            return price * ((100-discount) / 100.0);
        }
        return price;
    }

    protected void apply() {
        product.applyCoupon(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon)) return false;
        Coupon that = (Coupon) o;
        return Objects.equals(this.couponId, that.couponId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponId);
    }
}
