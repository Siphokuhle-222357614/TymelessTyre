package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.User;
import za.co.tt.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/users")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllCustomers() {
        List<User> users = userService.findAll()
                .stream()
                .filter(user -> "CUSTOMER".equalsIgnoreCase(user.getRole()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            userService.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> existingUser = userService.getById(id);
        if (existingUser.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
