package za.co.tt.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;
import za.co.tt.factory.ProductFactory;
import za.co.tt.repository.IProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IProductRepository productRepository;

    private Product testProduct;
    private Long savedProductId;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();

        testProduct = ProductFactory.createProduct(
                "Test Tire", "Model X", 225, 55, 17,
                Season.SUMMER, VehicleType.Sedan, 15000, 50,
                "http://example.com/tire.jpg", "High performance summer tire"
        );

        Product savedProduct = productRepository.save(testProduct);
        savedProductId = savedProduct.getProductId();
    }

    @Test
    public void testCreateProduct() {
        Product newProduct = ProductFactory.createProduct(
                "New Tire", "Model N", 195, 65, 16,
                Season.ALL_SEASON, VehicleType.SUV, 12000, 25,
                "new.jpg", "New all season tire"
        );

        ResponseEntity<Product> response = restTemplate.postForEntity(
                "/api/products", newProduct, Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("New Tire", response.getBody().getProductName());
        assertEquals(VehicleType.SUV, response.getBody().getVehicleType());
    }

    @Test
    public void testGetAllProducts() {
        Product product2 = ProductFactory.createProduct(
                "Winter Tire", "Model W", 205, 65, 16,
                Season.WINTER, VehicleType.SUV, 18000, 30,
                "winter.jpg", "Winter tire"
        );
        productRepository.save(product2);

        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                "/api/products", Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length >= 2);
    }

    @Test
    public void testGetProductById() {
        ResponseEntity<Product> response = restTemplate.getForEntity(
                "/api/products/" + savedProductId, Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Test Tire", response.getBody().getProductName());
        assertEquals(Season.SUMMER, response.getBody().getSeason());
    }

    @Test
    public void testUpdateProduct() {
        Product updatedProduct = ProductFactory.createProduct(
                "Updated Tire", "Model U", 235, 45, 18,
                Season.WINTER, VehicleType.Sports_Car, 18000, 30,
                "updated.jpg", "Updated winter tire"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Product> entity = new HttpEntity<>(updatedProduct, headers);

        ResponseEntity<Product> response = restTemplate.exchange(
                "/api/products/" + savedProductId,
                HttpMethod.PUT,
                entity,
                Product.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Tire", response.getBody().getProductName());
        assertEquals(Season.WINTER, response.getBody().getSeason());
        assertEquals(VehicleType.Sports_Car, response.getBody().getVehicleType());
    }

    @Test
    public void testDeleteProduct() {
        restTemplate.delete("/api/products/" + savedProductId);

        assertFalse(productRepository.findById(savedProductId).isPresent());
    }

    @Test
    public void testGetProductsBySeason() {
        Product winterProduct = ProductFactory.createProduct(
                "Winter Tire", "Model W", 205, 65, 16,
                Season.WINTER, VehicleType.SUV, 18000, 30,
                "winter.jpg", "Winter tire"
        );
        productRepository.save(winterProduct);

        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                "/api/products/season/SUMMER", Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(Season.SUMMER, response.getBody()[0].getSeason());
    }

    @Test
    public void testGetProductsByVehicleType() {
        Product suvProduct = ProductFactory.createProduct(
                "SUV Tire", "Model SUV", 265, 60, 18,
                Season.ALL_SEASON, VehicleType.SUV, 20000, 25,
                "suv.jpg", "SUV tire"
        );
        productRepository.save(suvProduct);

        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                "/api/products/vehicle-type/SEDAN", Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(VehicleType.Sedan, response.getBody()[0].getVehicleType());
    }

    @Test
    public void testGetProductsInStock() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                "/api/products/in-stock", Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getStockQuantity() > 0);
    }

    @Test
    public void testGetProductsByPriceRange() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                "/api/products/price-range?minPrice=10000&maxPrice=20000", Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(15000, response.getBody()[0].getProductPrice());
    }

    @Test
    public void testSearchProducts() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                "/api/products/search?searchTerm=performance", Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Test Tire", response.getBody()[0].getProductName());
    }

    @Test
    public void testUpdateStockQuantity() {
        ResponseEntity<Product> response = restTemplate.exchange(
                "/api/products/" + savedProductId + "/stock?stockQuantity=100",
                HttpMethod.PATCH,
                null,
                Product.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(100, response.getBody().getStockQuantity());
        assertEquals(savedProductId, response.getBody().getProductId());
    }
}