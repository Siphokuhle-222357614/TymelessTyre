package za.co.tt.service;

import org.springframework.stereotype.Service;
import za.co.tt.domain.Product;
import za.co.tt.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product updateProduct(Product product) {
        if (product.getProductId() == null || !repository.existsById(product.getProductId())) {
            throw new IllegalArgumentException("Product does not exist");
        }
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
