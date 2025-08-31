package za.co.tt.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="order")
public class Order {

    //Just placeholders to avoid errors, to be fixed by the owner of this entity..
    @Id
    @GeneratedValue
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @CreationTimestamp
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "addressId", nullable = false)
    private Address shippingAddress;

    private String status;
    private BigDecimal totalAmount;
    private String paymentMethod;

    public Order() {}

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;
        this.orderItems = builder.orderItems;
        this.orderDate = builder.orderDate;
        this.shippingAddress = builder.shippingAddress;
        this.status = builder.status;
        this.totalAmount = builder.totalAmount;
        this.paymentMethod = builder.paymentMethod;
    }

    public Long getOrderId() { return orderId; }
    public User getUser() { return user; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public LocalDate getOrderDate() { return orderDate; }
    public Address getShippingAddress() { return shippingAddress; }
    public String getStatus() { return status; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public String getPaymentMethod() { return paymentMethod; }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", orderItems=" + orderItems +
                ", orderDate=" + orderDate +
                ", shippingAddress=" + shippingAddress +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public static class Builder {
        private Long orderId;
        private User user;
        private List<OrderItem> orderItems;
        private LocalDate orderDate;
        private Address shippingAddress;
        private String status;
        private BigDecimal totalAmount;
        private String paymentMethod;

        public Builder setOrderId(Long orderId) {
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

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.user = order.user;
            this.orderItems = order.orderItems;
            this.orderDate = order.orderDate;
            this.shippingAddress = order.shippingAddress;
            this.status = order.status;
            this.totalAmount = order.totalAmount;
            this.paymentMethod = order.paymentMethod;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}