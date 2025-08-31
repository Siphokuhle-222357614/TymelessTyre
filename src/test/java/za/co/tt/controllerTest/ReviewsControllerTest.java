package za.co.tt.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import za.co.tt.domain.Reviews;
import za.co.tt.service.ReviewsService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewsControllerTest {

    @Test
    void testGetReviews() {
        ReviewsService service = mock(ReviewsService.class);
        ReviewsController controller = new ReviewsController(service);
        Reviews reviews = mock(Reviews.class);

        when(service.findById("1")).thenReturn(Optional.of(reviews));
        ResponseEntity<Reviews> response = controller.getReviews("1");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(reviews, response.getBody());
    }
}