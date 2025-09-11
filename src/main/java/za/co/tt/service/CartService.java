package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Cart;
import za.co.tt.repository.CartRepository;

import java.util.List;
@Service
public class CartService implements ICartService {

    @Autowired
    private final CartRepository cartRepository;


    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override

    public Cart save(Cart entity) {
        return cartRepository.save(entity);
    }

    @Override
    public Cart update(Cart entity) {
        return cartRepository.save(entity);
    }

    @Override
    public Cart read(Long id) {
        return cartRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        cartRepository.deleteById(id);

    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
}
