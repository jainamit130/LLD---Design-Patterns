package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

public class ItemNDiscountCoupon extends Coupon {
    private int productPosition;
    private ProductType type;
    public ItemNDiscountCoupon(String couponId, double discount, int productPosition, ProductType type,CartProduct product) throws CouponException {
        super(couponId, discount, product,1);
        this.productPosition = productPosition;
        this.type = type;
    }


    @Override
    protected boolean validate() throws CouponException {
        return super.validate() && product.getType().equals(type)
                && product.getCart().getPrefixPositionOfType(product) == productPosition;
    }

}
