package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.Tyre;

public interface ITyreRepository extends JpaRepository<Tyre, Long> {
}
