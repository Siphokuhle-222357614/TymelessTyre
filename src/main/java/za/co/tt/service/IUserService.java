package za.co.tt.service;

import za.co.tt.domain.User;

import java.util.Optional;

public interface IUserService extends IService<User, Long> {
    Optional<User> findByEmail(String email);
}
