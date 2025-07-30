package za.co.tt.domain;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tyres")
public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String brandName;

    @NotNull
    @Size(max = 50)
    private String tyreType;

    @Min(1)
    private int aspectRatio;

    @Min(1)
    private int width;

    @Min(1)
    private float wheelDiameter;

    @Min(1)
    private int maxLoad;

    @NotNull
    @Size(max = 5)
    private String speedRating;

    @Min(0)
    private float tyrePressure;

    @NotNull
    @Size(max = 20)
    private String tyreCode;

    @Size(max = 20)
    private String eoMark;

    @Size(max = 255)
    private String description;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    @Min(0)
    private int stockQuantity;

    @Size(max = 255)
    private String imageUrl;


    public Tyre(Builder builder) {
        this.id = builder.id;
        this.brandName = builder.brandName;
        this.tyreType = builder.tyreType;
        this.aspectRatio = builder.aspectRatio;
        this.width = builder.width;
        this.wheelDiameter = builder.wheelDiameter;
        this.maxLoad = builder.maxLoad;
        this.speedRating = builder.speedRating;
        this.tyrePressure = builder.tyrePressure;
        this.tyreCode = builder.tyreCode;
        this.eoMark = builder.eoMark;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.imageUrl = builder.imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getTyreType() {
        return tyreType;
    }

    public int getAspectRatio() {
        return aspectRatio;
    }

    public int getWidth() {
        return width;
    }

    public float getWheelDiameter() {
        return wheelDiameter;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public String getSpeedRating() {
        return speedRating;
    }

    public float getTyrePressure() {
        return tyrePressure;
    }

    public String getTyreCode() {
        return tyreCode;
    }

    public String getEoMark() {
        return eoMark;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", tyreType='" + tyreType + '\'' +
                ", aspectRatio=" + aspectRatio +
                ", width=" + width +
                ", wheelDiameter=" + wheelDiameter +
                ", maxLoad=" + maxLoad +
                ", speedRating='" + speedRating + '\'' +
                ", tyrePressure=" + tyrePressure +
                ", tyreCode='" + tyreCode + '\'' +
                ", eoMark='" + eoMark + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String brandName;
        private String tyreType;
        private int aspectRatio;
        private int width;
        private float wheelDiameter;
        private int maxLoad;
        private String speedRating;
        private float tyrePressure;
        private String tyreCode;
        private String eoMark;
        private String description;
        private BigDecimal price;
        private int stockQuantity;
        private String imageUrl;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setBrandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public Builder setTyreType(String tyreType) {
            this.tyreType = tyreType;
            return this;
        }

        public Builder setAspectRatio(int aspectRatio) {
            this.aspectRatio = aspectRatio;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setWheelDiameter(float wheelDiameter) {
            this.wheelDiameter = wheelDiameter;
            return this;
        }

        public Builder setMaxLoad(int maxLoad) {
            this.maxLoad = maxLoad;
            return this;
        }

        public Builder setSpeedRating(String speedRating) {
            this.speedRating = speedRating;
            return this;
        }

        public Builder setTyrePressure(float tyrePressure) {
            this.tyrePressure = tyrePressure;
            return this;
        }

        public Builder setTyreCode(String tyreCode) {
            this.tyreCode = tyreCode;
            return this;
        }

        public Builder setEoMark(String eoMark) {
            this.eoMark = eoMark;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Tyre build() {
            return new Tyre(this);
        }
    }
}