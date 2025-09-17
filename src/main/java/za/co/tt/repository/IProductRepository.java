package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBrand(String brand);
    List<Product> findByBrandAndModel(String brand, String model);
    List<Product> findByWidth(Integer width);
    List<Product> findByRimDiameter(Integer rimDiameter);
    List<Product> findBySeason(Season season);
    List<Product> findByVehicleType(VehicleType vehicleType);

    List<Product> findByWidthBetween(Integer minWidth, Integer maxWidth);
    List<Product> findByRimDiameterBetween(Integer minDiameter, Integer maxDiameter);
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
