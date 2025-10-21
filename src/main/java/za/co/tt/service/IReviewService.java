package za.co.tt.service;

import za.co.tt.domain.Review;
import java.util.List;
import java.util.Optional;

public interface IReviewService {
    List<Review> getAllReviews();
    Optional<Review> getReviewById(Long id);
    Review createReview(Review review);
    Review updateReview(Long id, Review review);
    void deleteReview(Long id);
    List<Review> getReviewsByProductId(Long productId);
    List<Review> getReviewsByRating(int rating);
    Double getAverageRatingByProductId(Long productId);
}