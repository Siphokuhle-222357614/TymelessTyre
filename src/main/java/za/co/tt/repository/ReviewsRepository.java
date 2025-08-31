package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, String> {
}