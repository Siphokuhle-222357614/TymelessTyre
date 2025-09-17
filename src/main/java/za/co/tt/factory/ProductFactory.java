package za.co.tt.factory;

import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;
import za.co.tt.util.Helper;

import java.math.BigDecimal;

public class ProductFactory {

    public static Product createProduct(String brand, String model, Integer width,
                                        Integer aspectRatio, Integer rimDiameter,
                                        String seasonStr, String vehicleTypeStr,
                                        String priceStr, Integer stockQuantity,
                                        String imageUrl, String description) {

        // Validate required fields
        if (Helper.isNullOrEmpty(brand) || Helper.isNullOrEmpty(model) ||
                width == null || aspectRatio == null || rimDiameter == null ||
                Helper.isNullOrEmpty(seasonStr) || Helper.isNullOrEmpty(vehicleTypeStr) ||
                Helper.isNullOrEmpty(priceStr)) {
            throw new IllegalArgumentException("Missing required product fields");
        }

        // Convert season string to enum
        Season season;
        try {
            season = Season.valueOf(seasonStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid season: " + seasonStr);
        }

        // Convert vehicle type string to enum
        VehicleType vehicleType;
        try {
            vehicleType = VehicleType.valueOf(vehicleTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid vehicle type: " + vehicleTypeStr);
        }

        // Parse price
        BigDecimal price;
        try {
            price = new BigDecimal(priceStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format: " + priceStr);
        }

        // Validate numeric values
        if (width <= 0 || aspectRatio <= 0 || rimDiameter <= 0 || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Width, aspect ratio, rim diameter, and price must be positive");
        }

        if (stockQuantity != null && stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }

        // Use the Builder pattern from your Product class
        return new Product.Builder()
                .setBrand(brand)
                .setModel(model)
                .setWidth(width)
                .setAspectRatio(aspectRatio)
                .setRimDiameter(rimDiameter)
                .setSeason(season)
                .setVehicleType(vehicleType)
                .setPrice(price)
                .setStockQuantity(stockQuantity != null ? stockQuantity : 0)
                .setImageUrl(imageUrl != null ? imageUrl : "")
                .setDescription(description != null ? description : "")
                .build();
    }
}
