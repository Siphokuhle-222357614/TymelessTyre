package za.co.tt.domain;

import jakarta.persistence.*;

@Entity
@Table(name ="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String reviewerName;
    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Review() {}

    public Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.reviewerName = builder.reviewerName;
        this.comment = builder.comment;
        this.rating = builder.rating;
        this.product = builder.product;
    }

    // Getters and setters
    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", product=" + (product != null ? product.getProductName(): "null") +
                '}';
    }

    public static class Builder {
        private Long reviewId;
        private String reviewerName;
        private String comment;
        private int rating;
        private Product product;

        public Builder setReviewId(Long reviewId) { this.reviewId = reviewId; return this; }
        public Builder setReviewerName(String reviewerName) { this.reviewerName = reviewerName; return this; }
        public Builder setComment(String comment) { this.comment = comment; return this; }
        public Builder setRating(int rating) { this.rating = rating; return this; }
        public Builder setProduct(Product product) { this.product = product; return this; }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.reviewerName = review.reviewerName;
            this.comment = review.comment;
            this.rating = review.rating;
            this.product = review.product;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}