package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public class ApplyOnceCoupon extends Coupon {


    public ApplyOnceCoupon(String couponId, double discount, CartProduct product,CouponType type) throws CouponException {
        super(couponId, discount, product,type);
    }

    @Override
    protected void apply() {
        super.apply();
        super.applyOnceCoupon(this);
    }

    @Override
    public boolean validateCoupon(Coupon coupon) {
        return super.validateCoupon(coupon) && product.validateApplyOnceCoupon(this);
    }
}
