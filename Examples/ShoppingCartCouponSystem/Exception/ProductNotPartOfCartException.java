package Examples.ShoppingCartCouponSystem.Exception;

public class ProductNotPartOfCartException extends CouponException {

    public ProductNotPartOfCartException(String message) {
        super(message);
    }
}
