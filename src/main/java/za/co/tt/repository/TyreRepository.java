package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.Tyre;

public interface TyreRepository extends JpaRepository<Tyre, Long> {

    // Custom query methods can be defined here if needed
    // For example:
    // List<Tyre> findBySize(String size);

    // Additional methods can be added as per requirements
}
