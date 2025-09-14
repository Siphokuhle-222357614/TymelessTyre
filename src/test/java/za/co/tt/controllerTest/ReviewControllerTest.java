package za.co.tt.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.co.tt.controller.ReviewController;
import za.co.tt.domain.Review;
import za.co.tt.service.ReviewService;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReviewControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReviewService service;

    @InjectMocks
    private ReviewController controller;

    private ObjectMapper mapper = new ObjectMapper();

    private Review sampleReview;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        sampleReview = new Review.Builder()
                .setReviewId("1")
                .setReviewerName("Test User")
                .setComment("Great product!")
                .setRating(5)
                .build();
    }

    @Test
    public void testCreateReview() throws Exception {
        when(service.createReview(any(Review.class))).thenReturn(sampleReview);

        mockMvc.perform(post("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(sampleReview)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comment").value("Great product!"));
    }

    @Test
    public void testGetReview() throws Exception {
        when(service.getReviewById("1")).thenReturn(Optional.of(sampleReview));

        mockMvc.perform(get("/api/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reviewId").value("1"));
    }

    @Test
    public void testGetReviewNotFound() throws Exception {
        when(service.getReviewById("2")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/reviews/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateReview() throws Exception {
        when(service.updateReview(any(Review.class))).thenReturn(sampleReview);

        mockMvc.perform(put("/api/reviews/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(sampleReview)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reviewId").value("1"));
    }

    @Test
    public void testDeleteReview() throws Exception {
        doNothing().when(service).deleteReview("1");

        mockMvc.perform(delete("/api/reviews/1"))
                .andExpect(status().isNoContent());
    }
}