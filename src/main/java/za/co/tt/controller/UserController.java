
package za.co.tt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.ChangePasswordRequest;
import za.co.tt.domain.LoginRequest;
import za.co.tt.domain.RegisterRequest;
import za.co.tt.domain.User;
import za.co.tt.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import za.co.tt.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = userService.login(request.getUsername(), request.getPassword());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String token = JwtUtil.generateToken(user);
            java.util.Map<String, Object> response = new java.util.HashMap<>();
            response.put("token", token);
            response.put("userId", user.getUserId());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/read/{userId}")
    public ResponseEntity<User> readUser(@PathVariable Long userId) {
        User user = userService.read(userId);
        if (user != null) {
            // Remove password from response for security
            user.setPassword(null);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/profile")
    public ResponseEntity<?> getCurrentUserProfile(HttpServletRequest request) {
        try {
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid authorization header");
            }
            
            String token = authHeader.substring(7);
            String username = JwtUtil.getUsernameFromToken(token);
            
            Optional<User> userOpt = userService.findByUsername(username);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                // Remove password from response for security
                user.setPassword(null);
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }

    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/readByUsername/{username}")
    public ResponseEntity<User> readByUsername(@PathVariable String username) {
        Optional<User> userOpt = userService.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Remove password from response for security
            user.setPassword(null);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User user) {
        try {
            // Security check: Customers can only update their own profile
            // (Admins can update any profile)
            // This would need JWT token parsing to get current user - simplified for now
            
            user.setUserId(userId);
            
            // Don't allow password updates through this endpoint
            User existingUser = userService.read(userId);
            if (existingUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            
            // Preserve the existing password
            user.setPassword(existingUser.getPassword());
            
            // Validate unique username and email
            if (!existingUser.getUsername().equals(user.getUsername())) {
                if (userService.findByUsername(user.getUsername()).isPresent()) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
                }
            }
            
            if (!existingUser.getEmail().equals(user.getEmail())) {
                if (userService.findByEmail(user.getEmail()).isPresent()) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered");
                }
            }

            User updatedUser = userService.update(user);
            
            // Remove password from response for security
            updatedUser.setPassword(null);
            
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Update failed: " + ex.getMessage());
        }
    }

    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @PutMapping("/change-password/{userId}")
    public ResponseEntity<?> changePassword(@PathVariable Long userId, @RequestBody ChangePasswordRequest request) {
        try {
            User existingUser = userService.read(userId);
            if (existingUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            
            // Verify current password
            if (!userService.verifyPassword(request.getCurrentPassword(), existingUser.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Current password is incorrect");
            }
            
            // Update password
            userService.updatePassword(userId, request.getNewPassword());
            
            return ResponseEntity.ok().body("Password updated successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password change failed: " + ex.getMessage());
        }
    }



    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
