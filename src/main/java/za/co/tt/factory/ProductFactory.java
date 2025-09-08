package za.co.tt.factory;

import za.co.tt.domain.Product;
import java.awt.image.BufferedImage;

public class ProductFactory {

    public static Product createProduct(String productName, String productDescription, String productBrand, double productPrice, int quantity, byte[] productImage){
        return new Product.Builder()
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setProductBrand(productBrand)
                .setProductPrice(productPrice)
                .setProductQuantity(quantity)
                .setProductImage(productImage)
                .build();
    }

    public static Product updateProduct(String productName, String productDescription, String productBrand, double productPrice, int quantity, byte[] productImage){
        return new Product.Builder()
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setProductBrand(productBrand)
                .setProductPrice(productPrice)
                .setProductQuantity(quantity)
                .setProductImage(productImage)
                .build();
    }

    public static Product deleteProduct(Long productId){
        return new Product.Builder()
                .setProductId(productId)
                .build();
    }

}
