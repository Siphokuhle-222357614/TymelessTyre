package za.co.tt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    private String id;
    private String productName;  // Tyre, Rim, etc.
    private int quantity;
    private double price;
    private double total;

    public OrderItem() {}

    public OrderItem(String id, String productName, int quantity, double price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = this.price * this.quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.total = this.price * this.quantity;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
