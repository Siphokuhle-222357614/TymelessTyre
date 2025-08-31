package za.co.tt.service;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Cart;
import za.co.tt.repository.CartRepository;
import za.co.tt.service.impl.CartServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceTest {

    @Test
    void testSaveCart() {
        CartRepository repo = mock(CartRepository.class);
        CartService service = new CartServiceImpl(repo);
        Cart cart = mock(Cart.class);

        when(repo.save(cart)).thenReturn(cart);
        Cart saved = service.save(cart);

        assertEquals(cart, saved);
    }
}