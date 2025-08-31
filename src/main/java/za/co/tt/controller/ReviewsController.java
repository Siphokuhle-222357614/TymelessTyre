package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.Reviews;
import za.co.tt.service.ReviewsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public ResponseEntity<Reviews> createReviews(@RequestBody Reviews reviews) {
        return ResponseEntity.ok(reviewsService.save(reviews));
    }

    @GetMapping("api/{id}")
    public ResponseEntity<Reviews> getReviews(@PathVariable String id) {
        return reviewsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.findAll());
    }

    @DeleteMapping("api/{id}")
    public ResponseEntity<Void> deleteReviews(@PathVariable String id) {
        reviewsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}