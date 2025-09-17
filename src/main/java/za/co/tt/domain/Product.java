package za.co.tt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import za.co.tt.domain.Enum.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Integer width;
    private Integer aspectRatio;
    private Integer rimDiameter;

    @Enumerated(EnumType.STRING)
    private Season season;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private BigDecimal price;
    private Integer stockQuantity;
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
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.width = builder.width;
        this.aspectRatio = builder.aspectRatio;
        this.rimDiameter = builder.rimDiameter;
        this.season = builder.season;
        this.vehicleType = builder.vehicleType;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.imageUrl = builder.imageUrl;
        this.description = builder.description;
        this.fitments = builder.fitments != null ? builder.fitments : new ArrayList<>();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) { this.model = model; }

    public Integer getWidth() { return width; }
    public void setWidth(Integer width) { this.width = width; }

    public Integer getAspectRatio() { return aspectRatio; }
    public void setAspectRatio(Integer aspectRatio) { this.aspectRatio = aspectRatio; }

    public Integer getRimDiameter() { return rimDiameter; }
    public void setRimDiameter(Integer rimDiameter) { this.rimDiameter = rimDiameter; }

    public Season getSeason() { return season; }
    public void setSeason(Season season) { this.season = season; }

    public VehicleType getVehicleType() { return vehicleType; }
    public void setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStockQuantity() { return stockQuantity; }
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
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", width=" + width +
                ", aspectRatio=" + aspectRatio +
                ", rimDiameter=" + rimDiameter +
                ", season=" + season +
                ", vehicleType=" + vehicleType +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", fitments=" + fitments +
                '}';
    }

    // Builder
    public static class Builder {
        private Long id;
        private String brand;
        private String model;
        private Integer width;
        private Integer aspectRatio;
        private Integer rimDiameter;
        private Season season;
        private VehicleType vehicleType;
        private BigDecimal price;
        private Integer stockQuantity;
        private String imageUrl;
        private String description;
        private List<ProductFitment> fitments;

        public Builder() {}

        public Builder setId(Long id) { this.id = id; return this; }
        public Builder setBrand(String brand) { this.brand = brand; return this; }
        public Builder setModel(String model) { this.model = model; return this; }
        public Builder setWidth(Integer width) { this.width = width; return this; }
        public Builder setAspectRatio(Integer aspectRatio) { this.aspectRatio = aspectRatio; return this; }
        public Builder setRimDiameter(Integer rimDiameter) { this.rimDiameter = rimDiameter; return this; }
        public Builder setSeason(Season season) { this.season = season; return this; }
        public Builder setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; return this; }
        public Builder setPrice(BigDecimal price) { this.price = price; return this; }
        public Builder setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; return this; }
        public Builder setImageUrl(String imageUrl) { this.imageUrl = imageUrl; return this; }
        public Builder setDescription(String description) { this.description = description; return this; }
        public Builder setFitments(List<ProductFitment> fitments) { this.fitments = fitments; return this; }

        public Product build() { return new Product(this); }
    }
}
