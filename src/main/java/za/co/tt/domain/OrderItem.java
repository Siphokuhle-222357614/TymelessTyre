// src/main/java/za/co/tt/domain/OrderItem.java
package za.co.tt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    private String id;

    // e.g. "Tyre", "Rim", "Accessory"
    private String category;

    // e.g. "18-inch Alloy Rim" or "Michelin Pilot Sport 4"
    private String productName;

    private int quantity;      // number of units
    private double price;      // unit price
    private double total;      // computed = quantity * price

    protected OrderItem() { }

    public OrderItem(String id, String category, String productName, int quantity, double price) {
        this.id = id;
        this.category = category;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = this.quantity * this.price;
    }

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
}
