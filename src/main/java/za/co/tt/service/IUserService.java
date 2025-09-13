package za.co.tt.service;

import za.co.tt.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IService<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
    Optional<User> findByUsernameAndRole(String username, String role);
}
