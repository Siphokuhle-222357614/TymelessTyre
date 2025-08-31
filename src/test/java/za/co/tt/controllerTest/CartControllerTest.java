package za.co.tt.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import za.co.tt.domain.Cart;
import za.co.tt.service.CartService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartControllerTest {

    @Test
    void testGetCart() {
        CartService service = mock(CartService.class);
        CartController controller = new CartController(service);
        Cart cart = mock(Cart.class);

        when(service.findById(1L)).thenReturn(Optional.of(cart));
        ResponseEntity<Cart> response = controller.getCart(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(cart, response.getBody());
    }
}