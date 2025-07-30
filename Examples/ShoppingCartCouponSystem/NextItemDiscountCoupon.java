package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public class NextItemDiscountCoupon extends ApplyOnceCoupon  {

    public NextItemDiscountCoupon(String couponId, double discount, CartProduct product) throws CouponException {
        super(couponId, discount, product,CouponType.NEXT_ITEM);
    }
}
