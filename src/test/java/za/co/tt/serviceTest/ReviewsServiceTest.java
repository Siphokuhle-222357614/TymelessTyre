package za.co.tt.service;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Reviews;
import za.co.tt.repository.ReviewsRepository;
import za.co.tt.service.impl.ReviewsServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewsServiceTest {

    @Test
    void testSaveReviews() {
        ReviewsRepository repo = mock(ReviewsRepository.class);
        ReviewsService service = new ReviewsServiceImpl(repo);
        Reviews reviews = mock(Reviews.class);

        when(repo.save(reviews)).thenReturn(reviews);
        Reviews saved = service.save(reviews);

        assertEquals(reviews, saved);
    }
}