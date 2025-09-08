package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
