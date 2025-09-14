package za.co.tt.service;

import za.co.tt.domain.Review;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReviewService {

    private final Map<String, Review> store = new HashMap<>();

    public Review createReview(Review review) {
        store.put(review.getReviewId(), review);
        return review;
    }

    public Optional<Review> getReviewById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Review> getAllReviews() {
        return new ArrayList<>(store.values());
    }

    public Review updateReview(Review review) {
        store.put(review.getReviewId(), review);
        return review;
    }

    public void deleteReview(String id) {
        store.remove(id);
    }
}