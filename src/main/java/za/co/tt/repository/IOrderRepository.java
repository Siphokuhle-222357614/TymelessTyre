package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
}
