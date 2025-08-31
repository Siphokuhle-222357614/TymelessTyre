package za.co.tt.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    protected Cart() {
        // JPA requires a default constructor
    }

    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.isActive = builder.isActive;
        this.user = builder.user;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public Long getCartId() {
        return cartId;
    }

    public boolean isActive() {
        return isActive;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", isActive=" + isActive +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static class Builder {
        private Long cartId;
        private boolean isActive;
        private User user;
        private LocalDate createdAt;
        private LocalDate updatedAt;

        public Builder cartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder createdAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDate updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartId = cart.cartId;
            this.isActive = cart.isActive;
            this.user = cart.user;
            this.createdAt = cart.createdAt;
            this.updatedAt = cart.updatedAt;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}