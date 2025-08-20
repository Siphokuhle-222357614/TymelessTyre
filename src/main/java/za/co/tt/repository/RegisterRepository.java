/*Author: Bonke Bulana - 220539995*/
package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

}
