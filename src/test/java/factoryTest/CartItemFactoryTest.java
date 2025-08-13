/*Author: Bonke Bulana*/
package factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.CartItem;
import za.co.tt.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {

    public static CartItem cartItem1 = CartItemFactory.createCartItem(10011L, 2, 1500, null, null, null);
    public static CartItem cartItem2 = CartItemFactory.createCartItem(10022L, 0, 0, null, null, null);

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