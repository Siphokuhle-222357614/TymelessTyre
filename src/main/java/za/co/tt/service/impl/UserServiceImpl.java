/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
package za.co.tt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.User;
import za.co.tt.domain.UserRole;
import za.co.tt.repository.UserRepository;
import za.co.tt.service.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User update(Long userId, User updateData) {
        return userRepository.findById(userId)
                .map(existing -> {
                    User updated = new User.Builder()
                            .setUserId(existing.getUserId())
                            .setFirstName(updateData.getFirstName() != null ? updateData.getFirstName() : existing.getFirstName())
                            .setLastName(existing.getLastName())
                            .setEmail(existing.getEmail())
                            .setPassword(existing.getPassword())
                            .setPhone(existing.getPhone())
                            .setRole(existing.getRole())
                            //.setIsActive(existing.isActive())
                            .build();
                    return userRepository.save(updated);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }



    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return userRepository.save(user);
    }


    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllByRole(UserRole role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
