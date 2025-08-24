package za.co.tt.factory;

import za.co.tt.domain.Rim;
import java.math.BigDecimal;

public class RimFactory {

    public static Rim createRim(String brandName, String manufactureCode, float rimSize,
                                String boltPattern, int boltCount, float boltSpacing,
                                BigDecimal price, int stockQuantity, String imageUrl) {
        return new Rim.Builder()
                .setBrandName(brandName)
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

    public static Rim updateRim(Long id, String brandName, String manufactureCode, float rimSize,
                                String boltPattern, int boltCount, float boltSpacing,
                                BigDecimal price, int stockQuantity, String imageUrl) {
        return new Rim.Builder()
                .setId(id)
                .setBrandName(brandName)
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