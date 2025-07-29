package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.CouponException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CartProduct extends Product {
    private ShoppingCart cart;
    private Product product;
    // 1 coupon can be applied only once
    protected Set<Coupon> appliedCoupons;

    public CartProduct(ShoppingCart cart,Product product) throws CouponException {
        super(product.getProductId(), product.getPrice(), product.getType());
        this.product = product;
        this.cart = cart;
        this.appliedCoupons = new HashSet<>();
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public boolean validateCoupon(Coupon coupon) {
        return !appliedCoupons.contains(coupon);
    }

    @Override
    public double getPrice() throws CouponException {
        return price;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    public void applyCoupon(Coupon coupon) {
        appliedCoupons.add(coupon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        CartProduct that = (CartProduct) o;
        return Objects.equals(this.productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
