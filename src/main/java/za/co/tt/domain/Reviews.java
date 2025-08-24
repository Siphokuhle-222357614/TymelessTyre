// src/main/java/za/co/tt/domain/Review.java
package za.co.tt.domain;

import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;             // Unique ID for the review
    private String orderItemId;    // ID of the tire/product being reviewed
    private String reviewerName;   // Name of the customer
    private int rating;            // Rating, e.g., 1-5
    private String comment;        // Text comment for feedback

    // Default constructor
    public Reviews() {}

    // Constructor with all fields
    public Reviews(String id, String orderItemId, String reviewerName, int rating, String comment) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", orderItemId='" + orderItemId + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
