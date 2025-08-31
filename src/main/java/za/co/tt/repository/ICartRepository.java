package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {



}
