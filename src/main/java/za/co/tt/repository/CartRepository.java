package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}