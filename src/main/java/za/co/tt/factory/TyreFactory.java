// src/main/java/za/co/tt/factory/TyreFactory.java
package za.co.tt.factory;

import za.co.tt.domain.Tyre;
import java.math.BigDecimal;

public class TyreFactory {

    public static Tyre createTyre(
            String brandName,
            String tyreType,
            int tyreSize,
            int aspectRatio,
            int width,
            float wheelDiameter,
            int maxLoad,
            String speedRating,
            float tyrePressure,
            String tyreCode,
            String eoMark,
            String description,
            BigDecimal price,
            int stockQuantity,
            String imageUrl
    ) {
        return new Tyre.Builder()
                .setBrandName(brandName)
                .setTyreType(tyreType)
                .setTyreSize(tyreSize)
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

    public static Tyre updateTyre(
            Long id,
            String brandName,
            String tyreType,
            int tyreSize,
            int aspectRatio,
            int width,
            float wheelDiameter,
            int maxLoad,
            String speedRating,
            float tyrePressure,
            String tyreCode,
            String eoMark,
            String description,
            BigDecimal price,
            int stockQuantity,
            String imageUrl
    ) {
        return new Tyre.Builder()
                .setId(id)
                .setBrandName(brandName)
                .setTyreType(tyreType)
                .setTyreSize(tyreSize)
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