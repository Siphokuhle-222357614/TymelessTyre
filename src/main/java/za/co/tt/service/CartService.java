package za.co.tt.service;

import org.springframework.stereotype.Service;
import za.co.tt.domain.Cart;
import za.co.tt.domain.CartItem;
import za.co.tt.domain.Product;
import za.co.tt.domain.User;
import za.co.tt.repository.CartRepository;
import za.co.tt.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    private final CartRepository cartRepository;
    private final IProductRepository productRepository;

    public CartService(CartRepository cartRepository, IProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // Existing methods...

    public Cart addProductToCart(Long userId, Long productId, int quantity) {
        // Find the cart for the user
        Optional<Cart> optionalCart = cartRepository.findByUser_UserId(userId);
        Cart cart = optionalCart.orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(new User(userId)); // assuming User(Long id) constructor
            newCart.setIsActive(true);
            return cartRepository.save(newCart);
        });

        // Check if product exists
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // Check if product already in cart
        boolean productExists = false;
        for (CartItem item : cart.getItems()) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                productExists = true;
                break;
            }
        }

        // If not already there, add it
        if (!productExists) {
            CartItem newItem = new CartItem();
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            cart.getItems().add(newItem);
        }

        return cartRepository.save(cart);
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
    public void deleteById(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new IllegalArgumentException("Cart with ID " + cartId + " not found");
        }
        cartRepository.deleteById(cartId);
    }

    @Override
    public Cart read(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
}