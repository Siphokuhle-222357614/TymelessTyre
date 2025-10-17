package za.co.tt.factory;

import za.co.tt.domain.Product;
import za.co.tt.domain.Enum.Season;
import za.co.tt.domain.Enum.VehicleType;

public class ProductFactory {

    public static Product createProduct(String productName, String productModel, int width,
                                        int aspectRatio, int rimDiameter, Season season,
                                        VehicleType vehicleType, double productPrice,
                                        int stockQuantity, String imageUrl, String description) {
        return new Product.Builder()
                .setProductName(productName)
                .setProductModel(productModel)
                .setWidth(width)
                .setAspectRatio(aspectRatio)
                .setRimDiameter(rimDiameter)
                .setSeason(season)
                .setVehicleType(vehicleType)
                .setProductPrice(productPrice)
                .setStockQuantity(stockQuantity)
                .setImageUrl(imageUrl)
                .setDescription(description)
                .build();
    }

    public static Product createProductWithId(Long productId, String productName, String productModel,
                                              int width, int aspectRatio, int rimDiameter,
                                              Season season, VehicleType vehicleType, double productPrice,
                                              int stockQuantity, String imageUrl, String description) {
        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setProductModel(productModel)
                .setWidth(width)
                .setAspectRatio(aspectRatio)
                .setRimDiameter(rimDiameter)
                .setSeason(season)
                .setVehicleType(vehicleType)
                .setProductPrice(productPrice)
                .setStockQuantity(stockQuantity)
                .setImageUrl(imageUrl)
                .setDescription(description)
                .build();
    }
}