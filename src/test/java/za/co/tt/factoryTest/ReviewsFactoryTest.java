package za.co.tt.factory;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Reviews;

import static org.junit.jupiter.api.Assertions.*;

class ReviewsFactoryTest {

    @Test
    void testCreateReviews() {
        Reviews reviews = ReviewsFactory.createReviews("1", "item1", "Good product", 5);

        assertNotNull(reviews);
        assertEquals("1", reviews.getId());
        assertEquals("item1", reviews.getOrderItemId());
        assertEquals("Good product", reviews.getComment());
        assertEquals(5, reviews.getRating());
    }
}