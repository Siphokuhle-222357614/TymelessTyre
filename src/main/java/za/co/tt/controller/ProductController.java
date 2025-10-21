
package za.co.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.access.prepost.PreAuthorize;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;
import za.co.tt.service.ProductService;

import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import za.co.tt.domain.ProductFitment;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create-with-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> createProductWithImage(
            @RequestParam("productName") String productName,
            @RequestParam("price") double price,
            @RequestParam("season") String season,
            @RequestParam("vehicleType") String vehicleType,
            @RequestParam(value = "productModel", required = false) String productModel,
            @RequestParam(value = "width", required = false, defaultValue = "0") int width,
            @RequestParam(value = "aspectRatio", required = false, defaultValue = "0") int aspectRatio,
            @RequestParam(value = "rimDiameter", required = false, defaultValue = "0") int rimDiameter,
            @RequestParam(value = "stockQuantity", required = false, defaultValue = "0") int stockQuantity,
            @RequestParam(value = "imageUrl", required = false) String imageUrl,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "fitments", required = false) String fitmentsJson,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setSeason(Season.valueOf(season));
        product.setVehicleType(VehicleType.valueOf(vehicleType));
        product.setProductModel(productModel);
        product.setWidth(width);
        product.setAspectRatio(aspectRatio);
        product.setRimDiameter(rimDiameter);
        product.setStockQuantity(stockQuantity);
        product.setImageUrl(imageUrl);
        product.setDescription(description);
        // Handle fitments JSON array
        if (fitmentsJson != null && !fitmentsJson.isBlank()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                List<ProductFitment> fitments = Arrays.asList(
                    mapper.readValue(fitmentsJson, ProductFitment[].class));
                for (ProductFitment fitment : fitments) {
                    fitment.setProduct(product);
                }
                product.setFitments(fitments);
            } catch (Exception e) {
                return ResponseEntity.status(400).body(null);
            }
        }
        if (file != null && !file.isEmpty()) {
            try {
                product.setImage(file.getBytes());
            } catch (Exception e) {
                return ResponseEntity.status(500).build();
            }
        }
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 🔹 Get all products (Customer/Admin)
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // 🔹 Get product by ID (Customer/Admin)
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Get product by name (Customer/Admin)
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/name/{productName}")
    public ResponseEntity<Product> getProductByName(@PathVariable String productName) {
        Optional<Product> product = productService.getProductByName(productName);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Create product (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    // 🔹 Update product (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        try {
            Product updatedProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Delete product (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Get products by season
    @GetMapping("/season/{season}")
    public ResponseEntity<List<Product>> getProductsBySeason(@PathVariable Season season) {
        List<Product> products = productService.getProductsBySeason(season);
        return ResponseEntity.ok(products);
    }

    // 🔹 Get products by vehicle type
    @GetMapping("/vehicle-type/{vehicleType}")
    public ResponseEntity<List<Product>> getProductsByVehicleType(@PathVariable VehicleType vehicleType) {
        List<Product> products = productService.getProductsByVehicleType(vehicleType);
        return ResponseEntity.ok(products);
    }

    // 🔹 Get in-stock products
    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> getProductsInStock() {
        List<Product> products = productService.getProductsInStock();
        return ResponseEntity.ok(products);
    }

    // 🔹 Get products by price range
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam int minPrice,
            @RequestParam int maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    // 🔹 Search products by term
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String searchTerm) {
        List<Product> products = productService.searchProducts(searchTerm);
        return ResponseEntity.ok(products);
    }

    // 🔹 Get products by tire specifications
    @GetMapping("/tire-specs")
    public ResponseEntity<List<Product>> getProductsByTireSpecifications(
            @RequestParam int width,
            @RequestParam int aspectRatio,
            @RequestParam int rimDiameter) {
        List<Product> products = productService.getProductsByTireSpecifications(width, aspectRatio, rimDiameter);
        return ResponseEntity.ok(products);
    }

    // 🔹 Update stock quantity
    @PatchMapping("/{id}/stock")
    public ResponseEntity<Product> updateStockQuantity(
            @PathVariable Long id,
            @RequestParam int stockQuantity) {
        try {
            Product updatedProduct = productService.updateStockQuantity(id, stockQuantity);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Upload product image (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadProductImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Product> productOpt = productService.getProductById(id);
        if (productOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        try {
            Product product = productOpt.get();
            product.setImage(file.getBytes());
            productService.updateProduct(id, product);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload image");
        }
    }

    // 🔹 Get product image
    @GetMapping(value = "/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long id) {
        Optional<Product> productOpt = productService.getProductById(id);
        if (productOpt.isEmpty() || productOpt.get().getImage() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productOpt.get().getImage());
    }

    // 🔹 Validate stock for a specific quantity (Public endpoint for frontend)
    @GetMapping("/{id}/validate-stock")
    public ResponseEntity<String> validateStock(@PathVariable Long id, @RequestParam int quantity) {
        try {
            Optional<Product> productOpt = productService.getProductById(id);
            if (productOpt.isEmpty()) {
                return ResponseEntity.status(400).body("{\"valid\": false, \"message\": \"Product not found\"}");
            }
            
            Product product = productOpt.get();
            boolean isValid = product.getStockQuantity() >= quantity;
            
            if (isValid) {
                return ResponseEntity.ok("{\"valid\": true, \"availableStock\": " + product.getStockQuantity() + ", \"message\": \"Stock available\"}");
            } else {
                return ResponseEntity.ok("{\"valid\": false, \"availableStock\": " + product.getStockQuantity() + ", \"requested\": " + quantity + ", \"message\": \"Insufficient stock\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"valid\": false, \"message\": \"Error validating stock: " + e.getMessage() + "\"}");
        }
    }

    // 🔹 Get current stock quantity (Public endpoint)
    @GetMapping("/{id}/stock")
    public ResponseEntity<String> getProductStock(@PathVariable Long id) {
        try {
            Optional<Product> productOpt = productService.getProductById(id);
            if (productOpt.isEmpty()) {
                return ResponseEntity.status(404).body("{\"error\": \"Product not found\"}");
            }
            
            Product product = productOpt.get();
            return ResponseEntity.ok("{\"productId\": " + id + ", \"stockQuantity\": " + product.getStockQuantity() + ", \"productName\": \"" + product.getProductName() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
