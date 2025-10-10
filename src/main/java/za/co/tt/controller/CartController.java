package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.Cart;
import za.co.tt.service.CartService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
    @RestController
    @RequestMapping("id/cart")

    public class CartController {

        private final CartService service;

        public CartController(CartService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
            Cart created = service.createCart(cart);
            return ResponseEntity.ok(created);
        }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Cart cart = service.read(id);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    } // made some changes, to avoid having errors.

        @GetMapping
        public ResponseEntity<List<Cart>> getAllCarts() {
            return ResponseEntity.ok(service.getAllCarts());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
            if (!id.equals(cart.getCartId())) {
                return ResponseEntity.badRequest().build();
            }
            try {
                Cart updated = service.createCart(cart);
                return ResponseEntity.ok(updated);
            } catch (IllegalArgumentException ex) {
                return ResponseEntity.notFound().build();
            }

        }
}
