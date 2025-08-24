package za.co.tt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String tyreType;
    private int tyreSize;
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

    public Tyre() {}


    public Tyre(Builder builder) {
        this.id = builder.id;
        this.brandName = builder.brandName;
        this.tyreType = builder.tyreType;
        this.tyreSize = builder.tyreSize;
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

    public int getTyreSize() {return tyreSize; }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setTyreType(String tyreType) {
        this.tyreType = tyreType;
    }

    public void setTyreSize(int tyreSize) {
        this.tyreSize = tyreSize;
    }

    public void setAspectRatio(int aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setWheelDiameter(float wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public void setSpeedRating(String speedRating) {
        this.speedRating = speedRating;
    }

    public void setTyrePressure(float tyrePressure) {
        this.tyrePressure = tyrePressure;
    }

    public void setTyreCode(String tyreCode) {
        this.tyreCode = tyreCode;
    }

    public void setEoMark(String eoMark) {
        this.eoMark = eoMark;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", tyreType='" + tyreType + '\'' +
                ", tyreSize=" + tyreSize +
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
        public Long id;
        public String brandName;
        public String tyreType;
        public int tyreSize;
        public int aspectRatio;
        public int width;
        public float wheelDiameter;
        public int maxLoad;
        public String speedRating;
        public float tyrePressure;
        public String tyreCode;
        public String eoMark;
        public String description;
        public BigDecimal price;
        public int stockQuantity;
        public String imageUrl;

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

        public Builder setTyreSize(int tyreSize) {
            this.tyreSize = tyreSize;
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