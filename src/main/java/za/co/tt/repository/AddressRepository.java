/*AddressRepository
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Address;
import java.util.*;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


    Optional<Address> findByPostalCode(Integer postalCode);
    List<Address> findAllByCity(String city);
}
