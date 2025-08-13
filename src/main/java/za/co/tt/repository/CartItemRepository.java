/*Author: Bonke Bulana*/
package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
