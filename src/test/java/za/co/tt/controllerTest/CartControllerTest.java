package za.co.tt.controllerTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.tt.domain.Cart;
import za.co.tt.domain.CartItem;
import za.co.tt.domain.Product;
import za.co.tt.domain.ProductFitment;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "/cart";

    private static CartItem addedItem;
    private static int userId = Math.toIntExact(1L);

    @Test
    @Order(1)
    void addItemToCart() {
        Product product = new Product();
        product.getId();
        product.setFitments(String.valueOf(List.of()));
        product.setPrice(BigDecimal.valueOf(1200.00));

        CartItem request = new CartItem();
        request.setQuantity(userId);
        request.setProductId(product.getId());
        request.setQuantity(2);

        ResponseEntity<CartItem> response = restTemplate.postForEntity(
                baseUrl + "/add", request, CartItem.class
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().getQuantity());
        assertEquals("Tyre Deluxe", response.getBody().getProductId().getClass());

        addedItem = response.getBody();
        System.out.println("Added item to cart: " + addedItem);
    }

    @Test
    @Order(2)
    void getCartByUserId() {
        assertNotNull(userId, "User ID must not be null");

        ResponseEntity<Cart[]> response = restTemplate.getForEntity(
                baseUrl + "/" + userId, Cart[].class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Cart should contain at least one item");

        System.out.println("Cart items retrieved for userId " + userId + ":");
        for (Cart c : response.getBody()) {
            System.out.println(c);
        }
    }

    @Test
    @Order(3)
    void removeItemFromCart() {
        assertNotNull(addedItem, "Added item must not be null");

        String url = baseUrl + "/remove/" + addedItem.getProductId();

        ResponseEntity<Void> response = restTemplate.exchange(
                url, HttpMethod.DELETE, null, Void.class
        );

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        System.out.println("Removed item with ID: " + addedItem.getProductId());
    }
}

