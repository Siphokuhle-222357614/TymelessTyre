package za.co.tt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.LoginRequest;
import za.co.tt.domain.RegisterRequest;
import za.co.tt.domain.User;
import za.co.tt.service.UserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User newUser = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Optional<User> user = userService.login(request.getUsername(), request.getPassword());

        if (user.isPresent()) {
            User loggedInUser = user.get();
            if ("ADMIN".equalsIgnoreCase(loggedInUser.getRole())) {
                return ResponseEntity.ok("Redirect to /admin/dashboard");
            } else if ("CUSTOMER".equalsIgnoreCase(loggedInUser.getRole())) {
                return ResponseEntity.ok("Redirect to /customer/dashboard");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unknown role");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<User> readUser(@PathVariable Long userId) {
        User user = userService.read(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
