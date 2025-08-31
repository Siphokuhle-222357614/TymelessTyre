package za.co.tt.factory;

import za.co.tt.domain.Cart;
import za.co.tt.domain.User;

import java.time.LocalDate;

public class CartFactory {

    public static Cart createCart(Long cartId, Boolean isActive, User user,
                                  LocalDate createdAt, LocalDate updatedAt) {

        // Validate fields
        if (cartId == null || cartId <= 0) {
            throw new IllegalArgumentException("Cart ID must be a positive value");
        }

        // Build the cart
        return new Cart.Builder()
                .setCartId(cartId)
                .setIsActive(isActive)
                .setUser(user)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
    }

}
