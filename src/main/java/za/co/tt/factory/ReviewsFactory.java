// src/main/java/za/co/tt/factory/ReviewFactory.java
package za.co.tt.factory;

import za.co.tt.domain.Reviews;
import java.util.UUID;

public class ReviewsFactory {

    // Create a Review with automatic ID
    public static Reviews create(String orderItemId, String reviewerName, int rating, String comment) {
        return new Reviews(UUID.randomUUID().toString(), orderItemId, reviewerName, rating, comment);
    }

    // Create a Review with specified ID
    public static Reviews create(String id, String orderItemId, String reviewerName, int rating, String comment) {
        return new Reviews(id, orderItemId, reviewerName, rating, comment);
    }
}
