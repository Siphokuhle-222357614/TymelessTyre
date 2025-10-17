package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;
import za.co.tt.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void createProduct_ShouldCreateProductWithoutId() {
        Product product = ProductFactory.createProduct(
                "Test Tire", "Model X", 225, 55, 17,
                Season.SUMMER, VehicleType.Sedan, 15000, 50,
                "http://example.com/tire.jpg", "High performance summer tire"
        );

        assertNotNull(product);
        assertNull(product.getProductId());
        assertEquals("Test Tire", product.getProductName());
        assertEquals("Model X", product.getProductModel());
        assertEquals(225, product.getWidth());
        assertEquals(55, product.getAspectRatio());
        assertEquals(17, product.getRimDiameter());
        assertEquals(Season.SUMMER, product.getSeason());
        assertEquals(VehicleType.Sedan, product.getVehicleType());
        assertEquals(15000, product.getProductPrice());
        assertEquals(50, product.getStockQuantity());
        assertEquals("http://example.com/tire.jpg", product.getImageUrl());
        assertEquals("High performance summer tire", product.getDescription());
    }

    @Test
    void createProductWithId_ShouldCreateProductWithId() {
        Product product = ProductFactory.createProductWithId(
                1L, "Test Tire", "Model X", 225, 55, 17,
                Season.SUMMER, VehicleType.Passenger, 15000, 50,
                "http://example.com/tire.jpg", "High performance summer tire"
        );

        assertNotNull(product);
        assertEquals(1L, product.getProductId());
        assertEquals("Test Tire", product.getProductName());
        assertEquals(Season.SUMMER, product.getSeason());
        assertEquals(VehicleType.Passenger, product.getVehicleType());
    }
}