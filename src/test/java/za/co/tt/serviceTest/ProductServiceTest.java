package za.co.tt.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.co.tt.domain.Product;
import za.co.tt.repository.ProductRepository;
import za.co.tt.service.ProductService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private Product sampleProduct;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        sampleProduct = new Product.Builder()
                .setProductId(1L)
                .setProductName("Sample")
                .setProductDescription("Desc")
                .setProductBrand("Brand")
                .setProductPrice(10.0)
                .setProductQuantity(1)
                .build();
    }

    @Test
    public void testCreateProduct() {
        when(repository.save(any(Product.class))).thenReturn(sampleProduct);
        Product created = service.createProduct(sampleProduct);
        assertEquals(sampleProduct, created);
        verify(repository).save(sampleProduct);
    }

    @Test
    public void testGetProductById() {
        when(repository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        Optional<Product> product = service.getProductById(1L);
        assertTrue(product.isPresent());
        assertEquals(sampleProduct, product.get());
    }

    @Test
    public void testUpdateProductSuccess() {
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(sampleProduct)).thenReturn(sampleProduct);
        Product updated = service.updateProduct(sampleProduct);
        assertEquals(sampleProduct, updated);
    }

    @Test
    public void testUpdateProductFail() {
        when(repository.existsById(1L)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateProduct(sampleProduct);
        });
    }

    @Test
    public void testDeleteProduct() {
        doNothing().when(repository).deleteById(1L);
        service.deleteProduct(1L);
        verify(repository).deleteById(1L);
    }
}
