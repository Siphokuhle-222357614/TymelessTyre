package za.co.tt.factory;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Cart;
import za.co.tt.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartFactoryTest {

    @Test
    void testCreateCart() {
        User user = mock(User.class);
        Cart cart = CartFactory.createCart(true, user, LocalDate.now(), LocalDate.now());

        assertNotNull(cart);
        assertEquals(user, cart.getUser());
        assertTrue(cart.isActive());
    }
}