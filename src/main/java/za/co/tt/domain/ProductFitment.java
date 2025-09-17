package za.co.tt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "product_fitments")
public class ProductFitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private Integer year;
    private String trim;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public ProductFitment() {}

    public ProductFitment(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.trim = builder.trim;
        this.product = builder.product;
    }

    // getters / setters
    public Long getId() { return id; }
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getTrim() { return trim; }
    public void setTrim(String trim) { this.trim = trim; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "ProductFitment{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", trim='" + trim + '\'' +
                ", product=" + product +
                '}';
    }

    public static class Builder {
        private String make;
        private String model;
        private Integer year;
        private String trim;
        private Product product;

        public Builder setMake(String make) { this.make = make; return this; }
        public Builder setModel(String model) { this.model = model; return this; }
        public Builder setYear(Integer year) { this.year = year; return this; }
        public Builder setTrim(String trim) { this.trim = trim; return this; }
        public Builder setProduct(Product product) { this.product = product; return this; }

        public ProductFitment build() { return new ProductFitment(this); }
    }
}
