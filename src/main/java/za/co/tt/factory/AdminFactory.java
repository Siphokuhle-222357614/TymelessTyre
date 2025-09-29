package za.co.tt.factory;

import za.co.tt.domain.Admin;

import java.time.LocalDate;

public class AdminFactory {

    /**
     * Creates a new Admin with all required fields.
     * @param username the admin's username
     * @param email the admin's email
     * @param role the role, e.g., "ADMIN"
     * @return a built Admin object
     */
    public static Admin createAdmin(String username, String email, String role) {
        return new Admin.Builder()
                .setUsername(username)
                .setEmail(email)
                .setRole(role)
                .setIsActive(true) // default active
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .build();
    }

    /**
     * Creates an Admin with optional fields (useful for testing or custom objects)
     */
    public static Admin createAdmin(String username, String email, String role, Boolean isActive, LocalDate createdAt, LocalDate updatedAt) {
        return new Admin.Builder()
                .setUsername(username)
                .setEmail(email)
                .setRole(role)
                .setIsActive(isActive)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
    }
}
