// src/main/java/za/co/tt/service/IReviewService.java
package za.co.tt.service;

import za.co.tt.domain.Reviews;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Reviews.
 * Defines basic CRUD operations for Review entities.
 */
public interface IReviewsService {

    /**
     * Save a review.
     * @param review the Review object to save
     * @return the saved Review
     */
    Reviews save(Reviews review);

    /**
     * Get all reviews.
     * @return a list of all Review objects
     */
    List<Reviews> findAll();

    /**
     * Find a review by its ID.
     * @param id the review ID
     * @return Optional containing the Review if found, empty otherwise
     */
    Optional<Reviews> findById(String id);

    /**
     * Find all reviews for a specific tire/order item.
     * @param orderItemId the ID of the tire/product
     * @return list of Review objects for that tire
     */
    List<Reviews> findByOrderItemId(String orderItemId);

    /**
     * Delete a review by ID.
     * @param id the review ID
     */
    void deleteById(String id);
}
