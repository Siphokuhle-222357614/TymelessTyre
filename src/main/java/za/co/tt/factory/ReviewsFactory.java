package za.co.tt.factory;

import za.co.tt.domain.Reviews;

import java.util.UUID;

public class ReviewsFactory {

    public static Reviews createReviews(String id, String orderItemId, String comment, int rating) {
        return new Reviews.Builder()
                .id(id)
                .orderItemId(orderItemId)
                .comment(comment)
                .rating(rating)
                .build();
    }

    // Minimal validation to avoid nulls/invalid ratings
    private static void validate(String orderItemId, String comment, int rating) {
        if (orderItemId == null || orderItemId.trim().isEmpty())
            throw new IllegalArgumentException("orderItemId is required");
        if (comment == null)
            throw new IllegalArgumentException("comment is required");
        if (rating < 1 || rating > 5)
            throw new IllegalArgumentException("rating must be between 1 and 5");
    }
}
