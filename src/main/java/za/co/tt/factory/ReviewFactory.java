package za.co.tt.factory;

import za.co.tt.domain.Review;
import za.co.tt.domain.Product;

public class ReviewFactory {

    public static Review createReview(String reviewerName, String comment, int rating, Product product) {
        return new Review.Builder()
                .setReviewerName(reviewerName)
                .setComment(comment)
                .setRating(rating)
                .setProduct(product)
                .build();
    }

    public static Review updateReview(Long reviewId, String reviewerName, String comment, int rating, Product product) {
        return new Review.Builder()
                .setReviewId(reviewId)
                .setReviewerName(reviewerName)
                .setComment(comment)
                .setRating(rating)
                .setProduct(product)
                .build();
    }

    public static Review deleteReview(Long reviewId) {
        return new Review.Builder()
                .setReviewId(reviewId)
                .build();
    }
}