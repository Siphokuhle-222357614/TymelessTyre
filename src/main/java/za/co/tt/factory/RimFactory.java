package za.co.tt.factory;

import za.co.tt.domain.Rim;
import java.math.BigDecimal;

public class RimFactory {

    // Method to create a Rim with default values
    public static Rim createRim() {
        return new Rim.Builder()
                .setId(1L)
                .setManufactureCode("DEFAULT_CODE")
                .setRimSize(16.0f)
                .setBoltPattern("5x100")
                .setBoltCount(5)
                .setBoltSpacing(100.0f)
                .setPrice(new BigDecimal("1000.00"))
                .setStockQuantity(50)
                .setImageUrl("http://example.com/default-rim.jpg")
                .build();
    }

    // Method to create a Rim with custom values
    public static Rim createCustomRim(Long id, String manufactureCode, float rimSize, String boltPattern,
                                      int boltCount, float boltSpacing, BigDecimal price, int stockQuantity, String imageUrl) {
        return new Rim.Builder()
                .setId(id)
                .setManufactureCode(manufactureCode)
                .setRimSize(rimSize)
                .setBoltPattern(boltPattern)
                .setBoltCount(boltCount)
                .setBoltSpacing(boltSpacing)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setImageUrl(imageUrl)
                .build();
    }
}