package za.co.tt.service.impl;

import org.springframework.stereotype.Service;
import za.co.tt.domain.Reviews;
import za.co.tt.repository.ReviewsRepository;
import za.co.tt.service.ReviewsService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public Reviews save(Reviews reviews) {
        return reviewsRepository.save(reviews);
    }

    @Override
    public Optional<Reviews> findById(String id) {
        return reviewsRepository.findById(id);
    }

    @Override
    public List<Reviews> findAll() {
        return reviewsRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        reviewsRepository.deleteById(id);
    }
}