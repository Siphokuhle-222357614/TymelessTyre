package za.co.tt.service;

import za.co.tt.domain.User;
import java.util.List;
import java.util.Optional;

public interface IUserService extends IService<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long userId);
}
