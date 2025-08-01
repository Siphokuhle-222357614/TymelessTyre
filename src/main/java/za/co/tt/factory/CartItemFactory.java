package za.co.tt.factory;

import za.co.tt.domain.Cart;
import za.co.tt.domain.CartItem;
import za.co.tt.domain.Rim;
import za.co.tt.domain.Tyre;

public class CartItemFactory {

    public static CartItem createCartItem(long cartItemId, int quantity, double price, Cart cart, Tyre tyre, Rim rim) {
        if (cartItemId <= 0 || quantity <= 0 || price <= 0 || cart == null || tyre == null || rim == null) {
            return null;
        }

        return new CartItem.Builder()
                .setCartItemId(cartItemId)
                .setQuantity(quantity)
                .setPrice(price)
//                .setCart(cart)
                .setTyre(tyre)
                .setRim(rim)
                .build();
    }
}
