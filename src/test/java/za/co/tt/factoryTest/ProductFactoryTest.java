package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFactoryTest {

    @Test
    public void testCreateProduct() {
        Product product = ProductFactory.createProduct(
                "Test Product",
                "Description",
                "BrandX",
                100.0,
                5,
                new byte[]{1, 2, 3}
        );

        assertNotNull(product);
        assertEquals("Test Product", product.getProductName());
        assertEquals("Description", product.getProductDescription());
        assertEquals("BrandX", product.getProductBrand());
        assertEquals(100.0, product.getProductPrice());
        assertEquals(5, product.getProductQuantity());
        assertArrayEquals(new byte[]{1, 2, 3}, product.getProductImage());
    }
}
