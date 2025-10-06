package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Cart;
import za.co.tt.domain.CartItem;
import za.co.tt.domain.Product;
import za.co.tt.domain.ProductFitment;
import za.co.tt.factory.CartFactory;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class CartFactoryTest {

    @Test
    void createCartWithSingleItem() {
        Product product = new Product();
        product.getId();
        product.setFitments(String.valueOf(Collections.singletonList(new ProductFitment())));
        product.setPrice(BigDecimal.valueOf(950.00));

        CartItem item = new CartItem(); // example constructor
        Cart cart = CartFactory.createCart(1L, item, "MyCart", BigDecimal.valueOf(950.00));

        assertNotNull(cart);
        assertEquals(1L, cart.getUser());
        assertEquals(1, cart.getItems().size());
        System.out.println("Cart with single item: " + cart);
    }

    @Test
    void createEmptyCart() {
        Cart emptyCart = CartFactory.createCart(2L, null, "EmptyCart", BigDecimal.ZERO);

        assertNotNull(emptyCart);
        assertEquals(2L, emptyCart.getUser());
        assertTrue(emptyCart.getItems().isEmpty());
        System.out.println("Empty cart: " + emptyCart);
    }

    @Test
    void createCartWithMultipleItems() {
        Product product1 = new Product();
        product1.getId();
        product1.setFitments("Tyre ZR");
        product1.setPrice(BigDecimal.valueOf(1200.00));

        Product product2 = new Product();
        product2.getId();
        product2.setFitments("All-Season Grip");
        product2.setPrice(BigDecimal.valueOf(1400.00));

        CartItem item1 = new CartItem();
        CartItem item2 = new CartItem();

        Cart cart = CartFactory.createCart(1L, item1, "MyCart", BigDecimal.valueOf(950.00));

        assertNotNull(cart);
        assertEquals(3L, cart.getUser());
        assertEquals(2, cart.getItems().size());
        System.out.println("Cart with multiple items: " + cart);
    }

}
