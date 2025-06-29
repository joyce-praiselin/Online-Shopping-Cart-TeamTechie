package service;

import java.util.ArrayList;
import java.util.List;
import bean.CartItem;
import bean.Product;

public class CartService {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeFromCart(int productId) {
        cartItems.removeIf(item -> item.getProduct().getId() == productId);
    }

    public void updateQuantity(int productId, int newQty) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(newQty);
                return;
            }
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
