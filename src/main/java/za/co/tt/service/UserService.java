
package za.co.tt.service;

import za.co.tt.domain.Address;
import za.co.tt.domain.Enum.AddressType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.tt.domain.RegisterRequest;
import za.co.tt.domain.User;
import za.co.tt.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
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
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        userRepository.deleteById(userId);
    }

    public Optional<User> login(String username, String password) {
    return userRepository.findByUsername(username)
        .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }

    public User register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        String role = (request.getRole() != null && !request.getRole().isBlank()) ? request.getRole().toUpperCase() : "CUSTOMER";
    User user = new User.Builder()
        .setName(request.getName())
        .setSurname(request.getSurname())
        .setUsername(request.getUsername())
        .setEmail(request.getEmail())
        .setPassword(passwordEncoder.encode(request.getPassword()))
        .setPhoneNumber(request.getPhoneNumber())
        .setRole(role)
        .build();

        // Add address for all users (including admins)
        AddressType addressTypeEnum = null;
        try {
            addressTypeEnum = AddressType.valueOf(
                request.getAddressType() != null ? request.getAddressType().toUpperCase() : "HOME");
        } catch (Exception e) {
            addressTypeEnum = AddressType.HOME;
        }

        Address address = new Address.Builder()
                .setStreet(request.getStreet())
                .setCity(request.getCity())
                .setState(request.getState())
                .setPostalCode(request.getPostalCode())
                .setCountry(request.getCountry())
                .setAddressType(addressTypeEnum)
                .setUser(user)
                .build();

        user.getAddresses().add(address);

        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void updatePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
