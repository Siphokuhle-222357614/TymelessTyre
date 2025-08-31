package za.co.tt.factory;

import za.co.tt.domain.Cart;
import za.co.tt.domain.User;

import java.time.LocalDate;

public class CartFactory {
    public static Cart createCart(boolean isActive, User user, LocalDate createdAt, LocalDate updatedAt) {
        return new Cart.Builder()
                .isActive(isActive)
                .user(user)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}