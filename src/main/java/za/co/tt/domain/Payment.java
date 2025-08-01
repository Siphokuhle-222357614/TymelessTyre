package za.co.tt.domain;
//import jakarta.persistence.*;
import java.time.LocalDate;

public class Payment {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    private String paymentMethod;
    private String paymentStatus;
    private double amount;
    private LocalDate paymentDate;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
      private Order order;

    protected Payment() {
    }

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.paymentMethod = builder.paymentMethod;
        this.paymentStatus = builder.paymentStatus;
        this.amount = builder.amount;
        this.paymentDate = builder.paymentDate;
        this.user = builder.user;
        this.order = builder.order;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
//                ", user=" + (user != null ? user.getUserID() : null) +
//                ", order=" + (order != null ? order.getOrderID() : null) +
                '}';
    }

    public static class Builder {
        private long paymentId;
        private String paymentMethod;
        private String paymentStatus;
        private double amount;
        private LocalDate paymentDate;
        private User user;
        private Order order;

        public Builder setPaymentId(long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.paymentMethod = payment.paymentMethod;
            this.paymentStatus = payment.paymentStatus;
            this.amount = payment.amount;
            this.paymentDate = payment.paymentDate;
            this.user = payment.user;
            this.order = payment.order;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
