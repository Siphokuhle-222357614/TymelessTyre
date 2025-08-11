/*UserRepository
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
package za.co.tt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllBy(String firstName);
    Optional<User> findUserByEmail(String email);

}