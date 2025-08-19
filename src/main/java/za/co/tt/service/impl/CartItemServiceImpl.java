/*Author: Bonke Bulana - 220539995 */
package za.co.tt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.CartItem;
import za.co.tt.domain.Payment;
import za.co.tt.repository.CartItemRepository;
import za.co.tt.repository.PaymentRepository;
import za.co.tt.service.ICartItemService;

import java.util.List;
@Service
public class CartItemServiceImpl implements ICartItemService {
    private CartItemRepository repository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository repository) {
        this.repository = repository;
    }


    @Override
    public CartItem create(CartItem cartItem) {
        return this.repository.save(cartItem);
    }

    @Override
    public CartItem read(Long cartItemId) {
        return this.repository.findById(cartItemId).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        if (this.repository.existsById(cartItem.getCartItemId()))
            return this.repository.save(cartItem);
        return null;
    }

    @Override
    public CartItem delete(Long cartItemId) {
        CartItem cartItem = read(cartItemId);
        if (cartItem != null) {
            this.repository.delete(cartItem);
            return cartItem;
        }
        return null;
    }

    @Override
    public List<CartItem> getAll() {
        return this.repository.findAll();
    }
}
