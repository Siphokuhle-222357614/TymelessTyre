package za.co.tt.service;

import za.co.tt.domain.Reviews;

import java.util.List;
import java.util.Optional;

public interface ReviewsService {
    Reviews save(Reviews reviews);
    Optional<Reviews> findById(String id);
    List<Reviews> findAll();
    void deleteById(String id);
}