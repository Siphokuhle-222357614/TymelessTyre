package za.co.tt.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // "order" is a reserved keyword in SQL
public class Order {
    @Id
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //
    @ElementCollection
    @CollectionTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderItem> orderItems = new ArrayList<>();



    private LocalDateTime orderDate;
    private String orderStatus;
    private double totalAmount;

    public Order() {}

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;
        this.orderItems = builder.orderItems;
        this.orderDate = builder.orderDate;
        this.orderStatus = builder.orderStatus;
        this.totalAmount = builder.totalAmount;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public User getUser() { return user; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getOrderStatus() { return orderStatus; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", user=" + user +
                ", orderItems=" + orderItems +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public static class Builder {
        private String orderId;
        private User user;
        private List<OrderItem> orderItems;
        private LocalDateTime orderDate;
        private String orderStatus;
        private double totalAmount;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.user = order.user;
            this.orderItems = order.orderItems;
            this.orderDate = order.orderDate;
            this.orderStatus = order.orderStatus;
            this.totalAmount = order.totalAmount;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
