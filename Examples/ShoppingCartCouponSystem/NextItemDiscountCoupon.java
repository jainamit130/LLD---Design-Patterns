package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public class NextItemDiscountCoupon extends Coupon {

    public NextItemDiscountCoupon(String couponId, double discount, CartProduct product) throws CouponException {
        super(couponId, discount, product,1);
    }
}
