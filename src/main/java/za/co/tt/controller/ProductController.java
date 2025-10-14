package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.co.tt.domain.Product;
import za.co.tt.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create a single product - now uses the interface method
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Bulk create products
    @PostMapping("/bulk")
    public ResponseEntity<?> createProducts(@RequestBody List<Product> products) {
        try {
            List<Product> savedProducts = productService.saveAllProducts(products);
            return ResponseEntity.ok(savedProducts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating products: " + e.getMessage());
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String filename = productService.storeFile(file);
        return ResponseEntity.ok(filename);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    // Get product by ID - now uses the interface method
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.read(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Advanced search with multiple parameters
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer width,
            @RequestParam(required = false) Integer aspectRatio,
            @RequestParam(required = false) Integer rimDiameter,
            @RequestParam(required = false) String season,
            @RequestParam(required = false) String vehicleType,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        List<Product> products = productService.searchProducts(brand, model, width, aspectRatio, rimDiameter, season, vehicleType, minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    // Simple search by brand
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        List<Product> products = productService.findAll().stream()
                .filter(product -> product.getBrand() != null && product.getBrand().equalsIgnoreCase(brand))
                .collect(java.util.stream.Collectors.toList());

        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.productExists(id)) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}