/*Author: Bonke Bulana*/
package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Payment;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Additional query methods can be defined here if needed



}
