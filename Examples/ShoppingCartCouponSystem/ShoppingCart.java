package Examples.ShoppingCartCouponSystem;

import Examples.ShoppingCartCouponSystem.Exception.ProductNotPartOfCartException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private String shoppingCartId;
    private List<Map<ProductType, Integer>> productPos;
    private List<CartProduct> products;

    public ShoppingCart(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
        this.products = new ArrayList<>();
        productPos = new ArrayList<>();
    }

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public int getPrefixPositionOfType(CartProduct product) {
        int index = products.indexOf(product);
        if (index < 0 || index >= productPos.size()) return -1;

        Map<ProductType, Integer> prefix = productPos.get(index);
        return prefix.getOrDefault(product.getType(), 0);
    }

    private void addToPrefix(CartProduct cartProduct) {
        Map<ProductType, Integer> lastPrefix =
                productPos.isEmpty() ? new HashMap<>() : new HashMap<>(productPos.get(productPos.size() - 1));

        ProductType type = cartProduct.getType();
        lastPrefix.put(type, lastPrefix.getOrDefault(type, 0) + 1);

        productPos.add(lastPrefix);
    }

    public void addProduct(CartProduct product) {
        products.add(product);
        addToPrefix(product);
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public int getItemNo(IProduct product) throws ProductNotPartOfCartException {
        try {
            return products.indexOf(product);
        } catch (NullPointerException exception) {
            throw new ProductNotPartOfCartException("Product : " + product.getProductId() + " not part of cart " + shoppingCartId);
        }
    }

}
