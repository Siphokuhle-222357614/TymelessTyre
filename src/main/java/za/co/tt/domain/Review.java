package za.co.tt.domain;

public class Review {
    private String reviewId;
    private String reviewerName;
    private String comment;
    private int rating; // 1-5 stars
    private Product product;

    public Review() {}

    public Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.reviewerName = builder.reviewerName;
        this.comment = builder.comment;
        this.rating = builder.rating;
        this.product = builder.product;
    }

    public String getReviewId() { return reviewId; }
    public String getReviewerName() { return reviewerName; }
    public String getComment() { return comment; }
    public int getRating() { return rating; }
    public Product getProduct() { return product; }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", product=" + (product != null ? product.getProductName() : "null") +
                '}';
    }

    public static class Builder {
        private String reviewId;
        private String reviewerName;
        private String comment;
        private int rating;
        private Product product;

        public Builder setReviewId(String reviewId) { this.reviewId = reviewId; return this; }
        public Builder setReviewerName(String reviewerName) { this.reviewerName = reviewerName; return this; }
        public Builder setComment(String comment) { this.comment = comment; return this; }
        public Builder setRating(int rating) { this.rating = rating; return this; }
        public Builder setProduct(Product product) { this.product = product; return this; }
        public Review build() { return new Review(this); }
    }
}
