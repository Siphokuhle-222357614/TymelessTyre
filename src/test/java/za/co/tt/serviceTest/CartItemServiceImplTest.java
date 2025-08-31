/*Author: Bonke Bulana - 220539995*/
package za.co.tt.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.tt.domain.Cart;
import za.co.tt.domain.CartItem;
import za.co.tt.domain.Rim;
import za.co.tt.domain.Tyre;
import za.co.tt.factory.CartItemFactory;
import za.co.tt.service.impl.CartItemServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CartItemServiceImplTest {

    @Autowired
    private CartItemServiceImpl cartItemService;

    private static Cart cart = new Cart();
    private static Tyre tyre = new Tyre();
    private static Rim rim = new Rim();

    private static CartItem cartItem = CartItemFactory.createCartItem(
            254, 2500,700, cart, tyre, rim
    );

    @Test
    void create() {
        System.out.println("Created: ");
        CartItem created = cartItemService.create(cartItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        System.out.println("Read: ");
        CartItem read = cartItemService.read(cartItem.getCartItemId());
        assertNotNull(read);
        assertEquals(cartItem.getCartItemId(), read.getCartItemId());
        System.out.println(read);
    }

    @Test
    void update() {
        CartItem updated = cartItemService.update(new CartItem.Builder()
                .copy(cartItem)
                .setQuantity(5)
                .build());
        System.out.println("Updated: ");
        assertNotNull(updated);
        assertEquals(5, updated.getQuantity());
        System.out.println(updated);
    }

    @Test
    void delete() {
        System.out.println("Deleted: ");
        CartItem deleted = cartItemService.delete(cartItem.getCartItemId());
        assertNotNull(deleted);
        System.out.println(deleted);
    }

    @Test
    void getAll() {
        System.out.println("All CartItems: ");
        assertNotNull(cartItemService.getAll());
        System.out.println(cartItemService.getAll());
    }
}
