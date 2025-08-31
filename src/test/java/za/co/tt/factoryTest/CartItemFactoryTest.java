/*Author: Bonke Bulana*/
package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Cart;
import za.co.tt.domain.CartItem;
import za.co.tt.domain.Rim;
import za.co.tt.domain.Tyre;
import za.co.tt.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {

    public static CartItem cartItem1 = CartItemFactory.createCartItem(10011L, 200, 1500, new Cart(), new Tyre(), new Rim());
    public static CartItem cartItem2 = CartItemFactory.createCartItem(10022L, 0, 0, new Cart(), new Tyre(), new Rim());

    @Test
    public void testCreateCartItemWithAllAttributes() {
        assertNotNull(cartItem1);
        System.out.println(cartItem1);
    }

    @Test
    public void testCreateCartItemThatFails() {
        assertNotNull(cartItem2);
        System.out.println(cartItem2);
    }
}