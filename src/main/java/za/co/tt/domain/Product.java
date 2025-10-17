package za.co.tt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import za.co.tt.domain.Enum.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String productModel;
    private int width;
    private int aspectRatio;
    private int rimDiameter;

    @Enumerated(EnumType.STRING)
    private Season season;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private double productPrice;
    private int stockQuantity;
    private String imageUrl;
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductFitment> fitments = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductFitment> fitmentReferences = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

    // Constructors
    public Product() {}

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productModel = builder.productModel;
        this.width = builder.width;
        this.aspectRatio = builder.aspectRatio;
        this.rimDiameter = builder.rimDiameter;
        this.season = builder.season;
        this.vehicleType = builder.vehicleType;
        this.productPrice = builder.productPrice;
        this.stockQuantity = builder.stockQuantity;
        this.imageUrl = builder.imageUrl;
        this.description = builder.description;
        this.fitments = builder.fitments != null ? builder.fitments : new ArrayList<>();
    }

    // Getters and setters

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }
    public void setProductModel(String productModel) { this.productModel = productModel; }

    public int getWidth() { return width; }
    public void setWidth(Integer width) { this.width = width; }

    public int getAspectRatio() { return aspectRatio; }
    public void setAspectRatio(Integer aspectRatio) { this.aspectRatio = aspectRatio; }

    public int getRimDiameter() { return rimDiameter; }
    public void setRimDiameter(Integer rimDiameter) { this.rimDiameter = rimDiameter; }

    public Season getSeason() { return season; }
    public void setSeason(Season season) { this.season = season; }

    public VehicleType getVehicleType() { return vehicleType; }
    public void setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; }

    public double getProductPrice() { return productPrice; }
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<ProductFitment> getFitments() { return fitments; }
    public void setFitments(List<ProductFitment> fitments) { this.fitments = fitments; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", brand='" + productName + '\'' +
                ", model='" + productModel + '\'' +
                ", width=" + width +
                ", aspectRatio=" + aspectRatio +
                ", rimDiameter=" + rimDiameter +
                ", season=" + season +
                ", vehicleType=" + vehicleType +
                ", price=" + productPrice +
                ", stockQuantity=" + stockQuantity +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", fitments=" + fitments +
                '}';
    }

    // Builder
    public static class Builder {
        private Long productId;
        private String productName;
        private String productModel;
        private int width;
        private int aspectRatio;
        private int rimDiameter;
        private Season season;
        private VehicleType vehicleType;
        private double productPrice;
        private int stockQuantity;
        private String imageUrl;
        private String description;
        private List<ProductFitment> fitments;

        public Builder() {}

        public Builder setProductId(Long productId) { this.productId = productId; return this; }
        public Builder setProductName(String productName) { this.productName = productName; return this; }
        public Builder setProductModel(String productModel) { this.productModel = productModel; return this; }
        public Builder setWidth(int width) { this.width = width; return this; }
        public Builder setAspectRatio(int aspectRatio) { this.aspectRatio = aspectRatio; return this; }
        public Builder setRimDiameter(int rimDiameter) { this.rimDiameter = rimDiameter; return this; }
        public Builder setSeason(Season season) { this.season = season; return this; }
        public Builder setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; return this; }
        public Builder setProductPrice(double productPrice) { this.productPrice = productPrice; return this; }
        public Builder setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; return this; }
        public Builder setImageUrl(String imageUrl) { this.imageUrl = imageUrl; return this; }
        public Builder setDescription(String description) { this.description = description; return this; }
        public Builder setFitments(List<ProductFitment> fitments) { this.fitments = fitments; return this; }

        public Product build() { return new Product(this); }

        }
    }

