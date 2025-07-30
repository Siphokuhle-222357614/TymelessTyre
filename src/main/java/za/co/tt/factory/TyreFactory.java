package za.co.tt.factory;

import za.co.tt.domain.Tyre;
import java.math.BigDecimal;

public class TyreFactory {

    // Method to create a Tyre with default values
    public static Tyre createTyre() {
        return new Tyre.Builder()
                .setId(1L)
                .setBrandName("Default Brand")
                .setTyreType("All-Season")
                .setAspectRatio(55)
                .setWidth(205)
                .setWheelDiameter(16.0f)
                .setMaxLoad(800)
                .setSpeedRating("V")
                .setTyrePressure(32.0f)
                .setTyreCode("DEFAULT_CODE")
                .setEoMark("E1")
                .setDescription("Default high-performance tyre")
                .setPrice(new BigDecimal("1200.00"))
                .setStockQuantity(20)
                .setImageUrl("http://example.com/default-tyre.jpg")
                .build();
    }

    // Method to create a Tyre with custom values
    public static Tyre createCustomTyre(Long id, String brandName, String tyreType, int aspectRatio, int width,
                                        float wheelDiameter, int maxLoad, String speedRating, float tyrePressure,
                                        String tyreCode, String eoMark, String description, BigDecimal price,
                                        int stockQuantity, String imageUrl) {
        return new Tyre.Builder()
                .setId(id)
                .setBrandName(brandName)
                .setTyreType(tyreType)
                .setAspectRatio(aspectRatio)
                .setWidth(width)
                .setWheelDiameter(wheelDiameter)
                .setMaxLoad(maxLoad)
                .setSpeedRating(speedRating)
                .setTyrePressure(tyrePressure)
                .setTyreCode(tyreCode)
                .setEoMark(eoMark)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setImageUrl(imageUrl)
                .build();
    }
}