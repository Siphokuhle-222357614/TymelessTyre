package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Reviews;
import za.co.tt.factory.ReviewsFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ReviewFactoryTest {

    @Test
    void testCreateWithId() {
        Reviews reviews = ReviewsFactory.create("rev101", "order123", "Excellent quality!", 5);

        assertNotNull(reviews);
        assertEquals("rev101", reviews.getId());
        assertEquals("order123", reviews.getOrderItemId());
        assertEquals("Excellent quality!", reviews.getComment());
        assertEquals(5, reviews.getRating());
    }

    @Test
    void testCreateWithoutId() {
        Reviews review = ReviewsFactory.create("order456", "Not bad, but could improve.", 3);

        assertNotNull(review);
        assertNotNull(review.getId()); // ID should be auto-generated
        assertEquals("order456", review.getOrderItemId());
        assertEquals("Not bad, but could improve.", review.getComment());
        assertEquals(3, review.getRating());
    }
}
