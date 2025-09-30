package za.co.tt.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.co.tt.controller.ProductController;
import za.co.tt.domain.Product;
import za.co.tt.service.ProductService;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    private ObjectMapper mapper = new ObjectMapper();

    private Product sampleProduct;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        sampleProduct = new Product.Builder()
                .setProductId(1L)
                .setProductName("Test Product")
                .setProductDescription("Description")
                .setProductBrand("Brand")
                .setProductPrice(100.0)
                .setProductQuantity(10)
                .build();
    }

    @Test
    public void testCreateProduct() throws Exception {
        when(service.createProduct(any(Product.class))).thenReturn(sampleProduct);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(sampleProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName").value("Test Product"));
    }

    @Test
    public void testGetProduct() throws Exception {
        when(service.getProductById(1L)).thenReturn(Optional.of(sampleProduct));

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(1L));
    }

    @Test
    public void testGetProductNotFound() throws Exception {
        when(service.getProductById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/products/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        when(service.updateProduct(any(Product.class))).thenReturn(sampleProduct);

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(sampleProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(1L));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        doNothing().when(service).deleteProduct(1L);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());
    }
}
