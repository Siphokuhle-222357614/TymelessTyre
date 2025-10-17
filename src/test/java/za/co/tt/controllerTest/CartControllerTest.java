package za.co.tt.controllerTest;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.co.tt.domain.Cart;
import za.co.tt.domain.User;
import za.co.tt.repository.UserRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    private static final String BASE_URL = "/api/cart";

    private static User testUser;
    private static Cart testCart;

    @BeforeAll
    static void setupMessage() {
        System.out.println("Starting CartController integration tests...");
    }

    @BeforeEach
    void setUp() {
        if (testUser == null || userRepository.findById(testUser.getUserId()).isEmpty()) {
            User user = new User();
            user.setName("Phelo Sfiso");
            user.setSurname("Madubela");
            user.setUsername("P.Madubela");
            user.setEmail("phelo.m@gmail.com");
            user.setPassword("password124");
            user.setPhoneNumber("0787830185");
            user.setRole("USER");
            user.setCreatedAt(LocalDateTime.now());

            testUser = userRepository.save(user);
        }
    }

    @Test
    @Order(1)
    void createCart() {
        Cart cart = new Cart();
        cart.setUser(testUser);
        cart.setIsActive(true);

        ResponseEntity<Cart> response = restTemplate.postForEntity(
                BASE_URL + "/create", cart, Cart.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getCartId());
        assertEquals(testUser.getUserId(), response.getBody().getUser().getUserId());

        testCart = response.getBody();
    }

    @Test
    @Order(2)
    void getCartById() {
        assertNotNull(testCart, "Cart should have been created in previous test");

        ResponseEntity<Cart> response = restTemplate.getForEntity(
                BASE_URL + "/" + testCart.getCartId(), Cart.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(testCart.getCartId(), response.getBody().getCartId());
    }

    @Test
    @Order(3)
    void getAllCarts() {
        ResponseEntity<Cart[]> response = restTemplate.getForEntity(
                BASE_URL + "/all", Cart[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Cart list should not be empty");
    }

    @Test
    @Order(4)
    void updateCart() {
        assertNotNull(testCart, "Cart should have been created in previous test");

        testCart.setIsActive(false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Cart> request = new HttpEntity<>(testCart, headers);

        ResponseEntity<Cart> response = restTemplate.exchange(
                BASE_URL + "/update/" + testCart.getCartId(),
                HttpMethod.PUT,
                request,
                Cart.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().getIsActive());
    }

    @Test
    @Order(5)
    void deleteCart() {
        assertNotNull(testCart, "Cart should have been created in previous test");

        restTemplate.delete(BASE_URL + "/delete/" + testCart.getCartId());

        ResponseEntity<Cart> response = restTemplate.getForEntity(
                BASE_URL + "/" + testCart.getCartId(), Cart.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
