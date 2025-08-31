package za.co.tt.service;

import za.co.tt.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart save(Cart cart);
    Optional<Cart> findById(Long id);
    List<Cart> findAll();
    void deleteById(Long id);
}