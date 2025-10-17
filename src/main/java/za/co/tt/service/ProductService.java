package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;
import za.co.tt.repository.IProductRepository;
import za.co.tt.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getProductId() != null) {
            throw new IllegalArgumentException("Product ID must be null for new product");
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setProductName(product.getProductName());
                    existingProduct.setProductModel(product.getProductModel());
                    existingProduct.setWidth(product.getWidth());
                    existingProduct.setAspectRatio(product.getAspectRatio());
                    existingProduct.setRimDiameter(product.getRimDiameter());
                    existingProduct.setSeason(product.getSeason());
                    existingProduct.setVehicleType(product.getVehicleType());
                    existingProduct.setProductPrice(product.getProductPrice());
                    existingProduct.setStockQuantity(product.getStockQuantity());
                    existingProduct.setImageUrl(product.getImageUrl());
                    existingProduct.setDescription(product.getDescription());
                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsBySeason(Season season) {
        return productRepository.findBySeason(season);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByVehicleType(VehicleType vehicleType) {
        return productRepository.findByVehicleType(vehicleType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsInStock() {
        return productRepository.findByStockQuantityGreaterThan(0);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByPriceRange(int minPrice, int maxPrice) {
        return productRepository.findByProductPriceBetween(minPrice, maxPrice);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> searchProducts(String searchTerm) {
        return productRepository.searchProducts(searchTerm);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByTireSpecifications(int width, int aspectRatio, int rimDiameter) {
        return productRepository.findByTireSpecifications(width, aspectRatio, rimDiameter);
    }

    @Override
    public Product updateStockQuantity(Long id, int newStockQuantity) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setStockQuantity(newStockQuantity);
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}