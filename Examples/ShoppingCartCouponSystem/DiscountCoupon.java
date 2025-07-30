package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public class DiscountCoupon extends Coupon {
    public DiscountCoupon(String couponId, double discount, CartProduct product) throws CouponException {
        super(couponId, discount, product,CouponType.REGULAR);
    }

    @Override
    protected boolean validate() {
        return validateCoupon(this);
    }
}
