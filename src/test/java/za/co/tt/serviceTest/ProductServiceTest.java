package za.co.tt.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;
import za.co.tt.factory.ProductFactory;
import za.co.tt.service.ProductService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private Product testProduct;

    @BeforeEach
    public void setUp() {
        testProduct = ProductFactory.createProduct(
                "Test Tire", "Model X", 225, 55, 17,
                Season.SUMMER, VehicleType.LightTruck, 15000, 50,
                "http://example.com/tire.jpg", "High performance summer tire"
        );
    }

    @Test
    public void testCreateProduct() {
        Product savedProduct = productService.createProduct(testProduct);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getProductId());
        assertEquals("Test Tire", savedProduct.getProductName());
        assertEquals(Season.SUMMER, savedProduct.getSeason());
        assertEquals(VehicleType.Passenger, savedProduct.getVehicleType());
    }

    @Test
    public void testGetAllProducts() {
        productService.createProduct(testProduct);

        Product anotherProduct = ProductFactory.createProduct(
                "Winter Tire", "Model W", 205, 65, 16,
                Season.WINTER, VehicleType.SUV, 18000, 30,
                "winter.jpg", "Winter tire"
        );
        productService.createProduct(anotherProduct);

        List<Product> products = productService.getAllProducts();

        assertNotNull(products);
        assertTrue(products.size() >= 2);
    }

    @Test
    public void testGetProductById() {
        Product savedProduct = productService.createProduct(testProduct);
        Long productId = savedProduct.getProductId();

        Optional<Product> foundProduct = productService.getProductById(productId);

        assertTrue(foundProduct.isPresent());
        assertEquals("Test Tire", foundProduct.get().getProductName());
        assertEquals(productId, foundProduct.get().getProductId());
    }

    @Test
    public void testUpdateProduct() {
        Product savedProduct = productService.createProduct(testProduct);
        Long productId = savedProduct.getProductId();

        Product updatedProductData = ProductFactory.createProduct(
                "Updated Tire", "Model Z", 235, 45, 18,
                Season.WINTER, VehicleType.Sports_Car, 18000, 30,
                "updated.jpg", "Updated description"
        );

        Product updatedProduct = productService.updateProduct(productId, updatedProductData);

        assertNotNull(updatedProduct);
        assertEquals(productId, updatedProduct.getProductId());
        assertEquals("Updated Tire", updatedProduct.getProductName());
        assertEquals(Season.WINTER, updatedProduct.getSeason());
        assertEquals(VehicleType.Sports_Car, updatedProduct.getVehicleType());
    }

    @Test
    public void testDeleteProduct() {
        Product savedProduct = productService.createProduct(testProduct);
        Long productId = savedProduct.getProductId();

        assertTrue(productService.getProductById(productId).isPresent());

        productService.deleteProduct(productId);

        assertFalse(productService.getProductById(productId).isPresent());
    }

    @Test
    public void testGetProductsBySeason() {
        productService.createProduct(testProduct);

        Product winterTire = ProductFactory.createProduct(
                "Winter Tire", "Model W", 205, 65, 16,
                Season.WINTER, VehicleType.SUV, 18000, 30,
                "winter.jpg", "Winter tire"
        );
        productService.createProduct(winterTire);

        List<Product> summerProducts = productService.getProductsBySeason(Season.SUMMER);

        assertFalse(summerProducts.isEmpty());
        assertEquals(Season.SUMMER, summerProducts.get(0).getSeason());
    }

    @Test
    public void testGetProductsByVehicleType() {
        productService.createProduct(testProduct);

        Product suvTire = ProductFactory.createProduct(
                "SUV Tire", "Model SUV", 265, 60, 18,
                Season.ALL_SEASON, VehicleType.SUV, 20000, 25,
                "suv.jpg", "SUV tire"
        );
        productService.createProduct(suvTire);

        List<Product> sedanProducts = productService.getProductsByVehicleType(VehicleType.Sedan);

        assertFalse(sedanProducts.isEmpty());
        assertEquals(VehicleType.Sedan, sedanProducts.get(0).getVehicleType());
    }
}