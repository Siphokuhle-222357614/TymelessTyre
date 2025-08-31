package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}