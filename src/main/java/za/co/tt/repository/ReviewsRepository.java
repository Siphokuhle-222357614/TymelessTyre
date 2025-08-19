// src/main/java/za/co/tt/repository/ReviewsRepository.java
package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Reviews;

import java.util.List;

/**
 * Repository interface for Review entities.
 * Provides CRUD operations and custom query for finding reviews by tire/order item.
 */
@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, String> {

    /**
     * Find all reviews for a specific tire/order item.
     * @param orderItemId the ID of the tire/product
     * @return list of Review objects
     */
    List<Reviews> findByOrderItemId(String orderItemId);
}
