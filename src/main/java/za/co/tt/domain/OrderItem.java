// src/main/java/za/co/tt/domain/OrderItem.java
package za.co.tt.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // e.g. "Tyre", "Rim", "Accessory"
    private String category;

    // e.g. "18-inch Alloy Rim" or "Michelin Pilot Sport 4"
    private String productName;

    private int quantity;      // number of units
    private double price;      // unit price
    private double total;      // computed = quantity * price

    public OrderItem() { }

    public OrderItem(Builder builder){
        this.id = builder.id;
        this.category = builder.category;
        this.productName = builder.productName;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.total = builder.quantity * builder.price;
    }

    public Long getId() { return id; }

    public String getCategory() { return category; }

    public String getProductName() { return productName; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        this.price = price;
        this.total = this.quantity * this.price;
    }

    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }

    public class Builder {
        private Long id;
        private String category;
        private String productName;
        private int quantity;
        private double price;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
