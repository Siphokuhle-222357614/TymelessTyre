package za.co.tt.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "order_item_id", nullable = false)
    private String orderItemId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private int rating; // 1..5

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Reviews() {
        // JPA requires a default constructor
    }

    private Reviews(Builder builder) {
        this.id = builder.id;
        this.orderItemId = builder.orderItemId;
        this.comment = builder.comment;
        this.rating = builder.rating;
        this.user = builder.user;
    }

    public String getId() {
        return id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id='" + id + '\'' +
                ", orderItemId='" + orderItemId + '\'' +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", user=" + (user != null ? user.getUserId() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reviews)) return false;
        Reviews reviews = (Reviews) o;
        return Objects.equals(id, reviews.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class Builder {
        private String id;
        private String orderItemId;
        private String comment;
        private int rating;
        private User user;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder orderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Reviews reviews) {
            this.id = reviews.id;
            this.orderItemId = reviews.orderItemId;
            this.comment = reviews.comment;
            this.rating = reviews.rating;
            this.user = reviews.user;
            return this;
        }

        public Reviews build() {
            return new Reviews(this);
        }
    }
}