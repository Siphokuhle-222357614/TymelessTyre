package za.co.tt.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;

    private String status;
    private BigDecimal totalAmount;
    private String paymentMethod;

    public Order() {
        // JPA requires a default constructor
    }

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;
        this.orderDate = builder.orderDate;
        this.shippingAddress = builder.shippingAddress;
        this.status = builder.status;
        this.totalAmount = builder.totalAmount;
        this.paymentMethod = builder.paymentMethod;
    }

    public Long getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
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
        private LocalDate orderDate;
        private Address shippingAddress;
        private String status;
        private BigDecimal totalAmount;
        private String paymentMethod;

        public Builder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}