package za.co.tt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserId(Long userId);
    User findByEmailAndPhone(String email, String phone);
    User findByEmailAndPassword(String email, String password);
    List<User> findAllByFirstName(String firstName);

}
