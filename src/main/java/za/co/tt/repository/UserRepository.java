package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername (String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByAddress(String address);
}
