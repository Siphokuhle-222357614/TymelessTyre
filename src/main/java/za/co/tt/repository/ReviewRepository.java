package za.co.tt.repository;

import za.co.tt.domain.Review;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviewsByProductId(String productId) {
        List<Review> result = new ArrayList<>();
        for (Review r : reviews) {
            if (r.getProduct() != null && r.getProduct().getProductId().equals(productId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<Review> getAllReviews() {
        return new ArrayList<>(reviews);
    }

    public double getAverageRating(String productId) {
        List<Review> productReviews = getReviewsByProductId(productId);
        if (productReviews.isEmpty()) return 0.0;
        int sum = 0;
        for (Review r : productReviews) {
            sum += r.getRating();
        }
        return (double) sum / productReviews.size();
    }
}
