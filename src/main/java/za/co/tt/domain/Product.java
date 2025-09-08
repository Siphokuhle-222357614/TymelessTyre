package za.co.tt.domain;

import java.awt.image.BufferedImage;

public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private String productBrand;
    private double productPrice;
    private int productQuantity;
    private BufferedImage productImage;

    public Product(){

    }

    public Product(Builder builder){
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
        this.productBrand = builder.productBrand;
        this.productPrice = builder.productPrice;
        this.productQuantity = builder.productQuantity;
        this.productImage = builder.productImage;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public BufferedImage getProductImage() {
        return productImage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productImage=" + productImage +
                '}';
    }

    public static class Builder {
        private String productId;
        private String productName;
        private String productDescription;
        private String productBrand;
        private double productPrice;
        private int productQuantity;
        private BufferedImage productImage;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder setProductBrand(String productBrand) {
            this.productBrand = productBrand;
            return this;
        }

        public Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder setProductQuantity(int productQuantity) {
            this.productQuantity = productQuantity;
            return this;
        }

        public Builder setProductImage(BufferedImage productImage) {
            this.productImage = productImage;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.productId = this.productId;
            product.productName = this.productName;
            product.productDescription = this.productDescription;
            product.productBrand = this.productBrand;
            product.productPrice = this.productPrice;
            product.productQuantity = this.productQuantity;
            product.productImage = this.productImage;
            return product;
        }
    }
}
