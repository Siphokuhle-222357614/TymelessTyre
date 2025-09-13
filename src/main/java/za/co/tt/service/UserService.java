package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.RegisterRequest;
import za.co.tt.domain.User;
import za.co.tt.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsernameAndRole(String username, String role) {
        return userRepository.findByUsernameAndRole(username, role);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        if (entity.getUserId() == null || !userRepository.existsById(entity.getUserId())) {
            throw new IllegalArgumentException("User does not exist");
        }
        return userRepository.save(entity);
    }

    @Override
    public User read(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
        userRepository.deleteById(userId);
    }

    public Optional<User> login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }

    public User register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = new User.Builder()
                .setUsername(request.getUsername())
                .setEmail(request.getEmail())
                .setPassword(request.getPassword())
                .setRole(request.getRole() != null ? request.getRole().toUpperCase() : "CUSTOMER")
                .build();

        return userRepository.save(user);
    }
}
