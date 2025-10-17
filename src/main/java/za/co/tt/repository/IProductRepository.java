package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductName(String productName);

    List<Product> findBySeason(Season season);

    List<Product> findByVehicleType(VehicleType vehicleType);

    List<Product> findByStockQuantityGreaterThan(int minStock);

    List<Product> findByProductPriceBetween(int minPrice, int maxPrice);

    @Query("SELECT p FROM Product p WHERE p.width = :width AND p.aspectRatio = :aspectRatio AND p.rimDiameter = :rimDiameter")
    List<Product> findByTireSpecifications(@Param("width") int width,
                                           @Param("aspectRatio") int aspectRatio,
                                           @Param("rimDiameter") int rimDiameter);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:searchTerm% OR p.productModel LIKE %:searchTerm% OR p.description LIKE %:searchTerm%")
    List<Product> searchProducts(@Param("searchTerm") String searchTerm);
}