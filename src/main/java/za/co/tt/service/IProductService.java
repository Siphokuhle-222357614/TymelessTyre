package za.co.tt.service;

import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Optional<Product> getProductByName(String productName);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getProductsBySeason(Season season);

    List<Product> getProductsByVehicleType(VehicleType vehicleType);

    List<Product> getProductsInStock();

    List<Product> getProductsByPriceRange(int minPrice, int maxPrice);

    List<Product> searchProducts(String searchTerm);

    List<Product> getProductsByTireSpecifications(int width, int aspectRatio, int rimDiameter);

    Product updateStockQuantity(Long id, int newStockQuantity);
}