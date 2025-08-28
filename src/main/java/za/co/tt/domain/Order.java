package za.co.tt.domain;

import jakarta.persistence.*;

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
    private user User;
    private List orderItems;
    private LocalDate orderDate;
    private address shippingAddress;
    private String status;
    private BigDecimal totalAmount;
    private String paymentMethod;

    public Order() {
    }

    private Order(Order.Builder builder) {
        this.orderId = builder.orderId;
        this.User = builder.User;
        this.orderItems = builder.orderItems;
        this.orderDate = builder.orderDate;
        this.shippingAddress = builder.shippingAddress;
        this.status = builder.status;
        this.totalAmount = builder.totalAmount;
        this.paymentMethod = builder.paymentMethod;

    }

   public Long getOrderId(){
        return orderId;
   }

    public user getUser(){
        return user;
    }

    public List getOrderItems(){
        return orderItems;
    }
    public LocalDate getOrderDate(){
        return orderDate;
    }

    public Address getshippingAddress(){
        return shippingAddress;
    }

    public String getStatus(){
        return status;

    }

    public BigDecimal getTotalAmount(){
        return totalAmount;
    }

    public String getPaymentMethod(){
        return paymentMethod;


    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", User=" + User +
                ", orderItems=" + orderItems +
                ", orderDate=" + orderDate +
                ", shippingAddress=" + shippingAddress +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public static class Builder{
        private Long orderId;
        private user User;//still needs my att
        private List orderItems;
        private LocalDate orderDate;
        private address shippingAddress;//needs my att
        private String status;
        private BigDecimal totalAmount;
        private String paymentMethod;

    }

    public Order setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Order setUser(user user) {// needs att still
        User = user;
        return this;
    }

    public Order setOrderItems(List orderItems) { //still needs att
        this.orderItems = orderItems;
        return this;
    }

    public Order setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Order setShippingAddress(address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public Order setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Order setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }
    public Order.Builder copy(Order order) {
        this.orderId = order.orderId;
        this.User = order.User;
        this.orderItems = order.orderItems;
        this.orderId = order.orderId;
        this.orderDate = order.orderDate;
        this.shippingAddress  = order.shippingAddress;
        this.status = order.status;
        this.totalAmount = order.totalAmount;
        this.paymentMethod = order.paymentMethod;
        return this;
    }
    public Order build() {
        return new Order(this);
    }


}

