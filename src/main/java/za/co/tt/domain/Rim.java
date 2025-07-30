package za.co.tt.domain;

import java.math.BigDecimal;

public class Rim {
    private Long id;
    private String manufactureCode;
    private float rimSize;
    private String boltPattern;
    private int boltCount;
    private float boltSpacing;
    private BigDecimal price;
    private int stockQuantity;
    private String imageUrl;

    public Rim() {
    }

    public Rim(Builder builder) {
        this.id = builder.id;
        this.manufactureCode = builder.manufactureCode;
        this.rimSize = builder.rimSize;
        this.boltPattern = builder.boltPattern;
        this.boltCount = builder.boltCount;
        this.boltSpacing = builder.boltSpacing;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.imageUrl = builder.imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getManufactureCode() {
        return manufactureCode;
    }

    public float getRimSize() {
        return rimSize;
    }

    public String getBoltPattern() {
        return boltPattern;
    }

    public int getBoltCount() {
        return boltCount;
    }

    public float getBoltSpacing() {
        return boltSpacing;
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
        return "Rim{" +
                "id=" + id +
                ", manufactureCode='" + manufactureCode + '\'' +
                ", rimSize=" + rimSize +
                ", boltPattern='" + boltPattern + '\'' +
                ", boltCount=" + boltCount +
                ", boltSpacing=" + boltSpacing +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String manufactureCode;
        private float rimSize;
        private String boltPattern;
        private int boltCount;
        private float boltSpacing;
        private BigDecimal price;
        private int stockQuantity;
        private String imageUrl;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setManufactureCode(String manufactureCode) {
            this.manufactureCode = manufactureCode;
            return this;
        }

        public Builder setRimSize(float rimSize) {
            this.rimSize = rimSize;
            return this;
        }

        public Builder setBoltPattern(String boltPattern) {
            this.boltPattern = boltPattern;
            return this;
        }

        public Builder setBoltCount(int boltCount) {
            this.boltCount = boltCount;
            return this;
        }

        public Builder setBoltSpacing(float boltSpacing) {
            this.boltSpacing = boltSpacing;
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

        public Rim build() {
            return new Rim(this);
        }
    }
}
