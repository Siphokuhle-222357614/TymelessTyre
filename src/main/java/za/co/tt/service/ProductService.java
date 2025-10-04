package za.co.tt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.co.tt.domain.Cart;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;
import za.co.tt.repository.IProductRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class ProductService implements IService<Product, Long> {

    private final IProductRepository productRepository;
    private final Path uploadDir;

    public ProductService(IProductRepository productRepository,
                          @Value("${file.upload-dir}") String uploadDir) {
        this.productRepository = productRepository;
        this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            if (!Files.exists(this.uploadDir)) {
                Files.createDirectories(this.uploadDir);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory", e);
        }
    }

    // Implement IService methods
    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product update(Product entity) {
        if (productRepository.existsById(entity.getId())) {
            return productRepository.save(entity);
        }
        return null; // or throw exception
    }

    @Override
    public ResponseEntity<Cart> deleteById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Product read(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Keep your existing methods with some adjustments
    public String storeFile(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String fileExtension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                fileExtension = originalFilename.substring(originalFilename.lastIndexOf('.'));
            }
            String uniqueFilename = UUID.randomUUID().toString() + fileExtension;
            Path targetLocation = this.uploadDir.resolve(uniqueFilename);
            Files.copy(file.getInputStream(), targetLocation);
            return uniqueFilename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file: " + file.getOriginalFilename(), e);
        }
    }

    // This method is now redundant with the save() method, but you can keep it as a wrapper if needed
    public Product saveProduct(Product product) {
        return save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> searchProducts(String brand, String model,
                                        Integer width, Integer aspectRatio,
                                        Integer rimDiameter, String season,
                                        String vehicleType,
                                        Double minPrice, Double maxPrice) {

        BigDecimal min = (minPrice == null) ? null : BigDecimal.valueOf(minPrice);
        BigDecimal max = (maxPrice == null) ? null : BigDecimal.valueOf(maxPrice);

        return productRepository.findAll().stream()
                .filter(product -> brand == null || product.getBrand() == null || product.getBrand().equalsIgnoreCase(brand))
                .filter(product -> model == null || product.getModel() == null || product.getModel().equalsIgnoreCase(model))
                .filter(product -> width == null || product.getWidth() == null || product.getWidth().equals(width))
                .filter(product -> aspectRatio == null || product.getAspectRatio() == null || product.getAspectRatio().equals(aspectRatio))
                .filter(product -> rimDiameter == null || product.getRimDiameter() == null || product.getRimDiameter().equals(rimDiameter))
                .filter(product -> season == null || product.getSeason() == null || product.getSeason().name().equalsIgnoreCase(season))
                .filter(product -> vehicleType == null || product.getVehicleType() == null || product.getVehicleType().name().equalsIgnoreCase(vehicleType))
                .filter(product -> min == null || product.getPrice() == null || product.getPrice().compareTo(min) >= 0)
                .filter(product -> max == null || product.getPrice() == null || product.getPrice().compareTo(max) <= 0)
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsByVehicle(String make, String model, Integer year) {
        // Placeholder: implement when Vehicle entity/relation exists
        return productRepository.findAll();
    }

    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    // This method is now redundant with deleteById() but you can keep it as a wrapper
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public boolean productExists(Long id) {
        return productRepository.existsById(id);
    }
}